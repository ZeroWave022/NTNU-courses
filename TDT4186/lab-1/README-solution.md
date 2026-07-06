# TDT4186: Lab 1

## Task 1: Hello world

Performed changes:

- Wrote the program `user/hello.c`
- Added `_hello` to the [Makefile](./Makefile)

## Task 2: Process Management

Performed changes:

- Defined `SYS_ps` in syscall.h
- Defined `sys_ps` in syscall.c
- Wrote `sys_ps` in `kernel/sysproc.c`
- Wrote the program `user/ps.c`
- Added the `ps` entry to `user/usys.pl`
- Added the `ps` entry to `user/user.h`
- Added the `ps` user-space entry to the [Makefile](./Makefile)
- Added the `list_processes` function to proc.c and defs.h.

Optional:

- Defined `SYS_proctree` in syscall.h
- Defined `sys_proctree` in syscall.c
- Wrote `sys_proctree` in `kernel/sysproc.c`
- Wrote the program `user/proctree.c`
- Added the `proctree` entry to `user/usys.pl`
- Added the `proctree` entry to `user/user.h`
- Added the `proctree` user-space entry to the [Makefile](./Makefile)
- Added the `proctree` function to proc.c and defs.h.
