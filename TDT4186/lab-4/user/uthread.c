#include "kernel/types.h"
#include "user.h"
#include "kernel/riscv.h"
#define LIB_PREFIX "[UTHREAD]: "
#define ulog() printf("%s%s\n", LIB_PREFIX, __FUNCTION__)

void tsched()
{
    // TODO: Implement a userspace round robin scheduler that switches to the next thread
    struct thread *prev_thread = current_thread;

    for (int i = 1; i <= 256; i++)
    {
        int next_tid = (current_thread->tid + i) % 256;
        if (threads[next_tid] != 0 && threads[next_tid]->state == RUNNABLE)
        {
            current_thread = threads[next_tid];
            current_thread->state = RUNNING;
            tswtch(&prev_thread->tcontext, &current_thread->tcontext);
            break;
        }
    }
}

static void tstart(void)
{
    current_thread->res = current_thread->func(current_thread->arg);
    current_thread->state = EXITED;
    tsched();
    exit(0);
}

void tcreate(struct thread **thread, struct thread_attr *attr, void *(*func)(void *arg), void *arg)
{
    // TODO: Create a new process and add it as runnable, such that it starts running
    // once the scheduler schedules it the next time
    *thread = (struct thread *)malloc(sizeof(struct thread));

    uint32 stacksize = (attr != 0 && attr->stacksize) ? attr->stacksize : PGSIZE;
    uint32 res_size = (attr != 0 && attr->res_size) ? attr->res_size : 0;

    // Find next available tid
    int tid = 0;
    for (; tid < 256; tid++)
    {
        if (threads[tid] == 0)
        {
            break;
        }
    }

    if (tid == 256)
    {
        free(*thread);
        return;
    }

    (*thread)->tid = tid;
    (*thread)->state = RUNNABLE;
    (*thread)->func = func;
    (*thread)->arg = arg;
    (*thread)->res_size = res_size;
    (*thread)->res = 0;

    void *stack = malloc(stacksize);

    uint64 sp = (uint64)stack + stacksize;
    sp &= ~((uint64)0xf);

    memset(&(*thread)->tcontext, 0, sizeof(struct context));
    (*thread)->tcontext.ra = (uint64)tstart;
    (*thread)->tcontext.sp = sp;
    (*thread)->stack = stack;

    threads[tid] = *thread;
}

int tjoin(int tid, void *status, uint size)
{
    // TODO: Wait for the thread with TID to finish. If status and size are non-zero,
    // copy the result of the thread to the memory, status points to. Copy size bytes.
    if (tid < 0 || tid >= 256 || tid == twhoami())
    {
        return -1;
    }

    struct thread *target = threads[tid];

    if (target == 0)
    {
        return -1;
    }

    while (target->state != EXITED)
    {
        tyield();
    }

    if (status && size > 0 && target->res && target->res_size > 0)
    {
        uint32 min_copy_size = size < target->res_size ? size : target->res_size;
        memcpy(status, target->res, min_copy_size);
    }

    threads[tid] = 0;
    free(target->stack);
    free(target);

    return 0;
}

void tyield()
{
    if (current_thread && current_thread->state == RUNNING)
    {
        current_thread->state = RUNNABLE;
    }
    tsched();
}

uint8 twhoami()
{
    // TODO: Returns the thread id of the current thread
    return current_thread->tid;
}
