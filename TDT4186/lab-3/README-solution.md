## TDT4186: Lab 3

Performed changes:

Added `vatopa` to the Makefile
Implemented `sys_va2pa` to `sysproc.c`
Added `va2pa` to `defs.h`
Wrote `va2pa` in `proc.c`
Wrote `vatopa.c` user-space program
Added reference counter `kalloc.c`
Added new functions from `kalloc.c` to `defs.h`
Adjusted `kfree` and `kalloc` in `kalloc.c`
Adjusted `usertrap` in `trap.c`
Adjusted `uvmcopy` in `vm.c` and added `uvmforcecopy`
