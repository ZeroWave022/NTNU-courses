#include "kernel/types.h"
#include "kernel/stat.h"
#include "user/user.h"
#include "kernel/fs.h"

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: vatopa virtual_address [pid]\n");
        exit(1);
    }

    uint64 va = atoi(argv[1]);

    if (argc == 3)
    {
        int pid = atoi(argv[2]);
        int pa = va2pa(va, pid);
        printf("0x%x\n", pa);
    }
    else
    {
        printf("0x%x\n", va2pa(va, 0));
    }

    exit(0);
}
