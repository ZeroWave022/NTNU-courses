# TDT4186: Optional exercise 1

## Theoretical exercises

1. What do you have to do before you can run your C program? In other words, which steps
do you have to repeat if you change anything in your code so that the code produces a new
output?

After making changes to the code, it must be recompiled.
More specifically, it must be pre-processed, compiled and linked again. One option is to use the `gcc` compiler.

2. As we highlighted in the exercise lecture, the compiler is your friend. With what can the
compiler help you? Which things can the compiler not help you with? Which other tools
can you use if the compiler cannot provide support?

The compiler can help with detecting errors when using the `-Wall` flag,
it can help with making the code faster if using `-O2` flag and general type checking.

Sometimes, the code may contain logical errors or other bugs that the compiler cannot find.
In such cases, manual debugging is required.

3. Scenario: After you start your program, it runs for a few seconds before it crashes. The only
output to the console immediately before the crash is `SEGFAULT`. Which tools could be useful
to debug such an error?

In this case, it may be useful to use a debugger such as `gdb`. Another useful tool is `valgrind` which can help check memory management issues.

4. **Pointer arithmetic**: A pointer is a special type of variable that contains an address that
points to a memory location. As with any normal variable, you can apply operations to the
value stored in a pointer variable, but it has some minor differences in behavior.
For this exercise, read the code block below carefully. If you want to read up on pointers and
how to operate on them, you can find a chapter on pointers on Blackboard.

```c
struct point
{
    int x;
    int y;
    int z;
};

int main()
{
    struct point pArray[4] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    pArray[1].z = 1025;
    int *i = (int *)(pArray + 1);
    *i = 4;
    i = (int *)(((void *)i) + 9);
    char *c = (char *)i;
    printf("c: %d\n", *c);
    *((int *)(c + 4) + 1) = 5;
    printf("%d\n", pArray[2].y);
}
```

a) Which values does `pArray` store after line 10 was executed? What values would it be without the part after the =?

`pArray` is a 2D array with a max size of 4 elements. After line 10 is executed, `pArray` stores the values shown.

After editing the code to not initialize `pArray` and inspecting the contents using `gdb`, most of the values seem to be set to 0, however some receive random values.

b) On line 13, where is the 4 stored? Is this a valid storage location, or are we touching storage that has not been allocated?

The pointer `i` is pointing to the second element in the `pArray`. Since this element is a set, the point will be default be pointing to the first element of this set.

Therefore, after running line 13, the first element of second set will be set to 4.

c) What will be printed on line 16?

On line 14, we increase the pointer by 9 bytes. Each int is 4 bytes, so we move from reading `pArray[1].x` to reading `pArray[1].z`. More specifically, we are reading the second byte of the `z` attribute. We know the value of `pArray[1].z` is 1025.

The value 1025 is `0x401` in hex. Assuming storing the value from least significant digit to most significant, this would be stored as `01 04 00 00`.

We then type cast the pointer from int to char, and the second byte is `04`, so the output becomes `c: 4`.

d) What will be printed on line 18?

We first increase the `c` pointer by four bytes and cast it to an int pointer, so it will point to the second byte of `pArray[2].x`.
Then, we perform pointer arithmetic and the result is adding another 4 bytes because that's the size of integers.
So, in the end, the pointer on line 17 points to the second byte of `pArray[2].y`.

We set the value of the second byte of `pArray[2].y` to 5. So, the stored value now becomes `00 05 00 00`, meaning 0x500. The print therefore shows 1280.

e) What would be the result of the following snippet? Explain your solution. Would it be different if we cast i to a short?

Assume 32-bit integers (=4 bytes).

```c
int *i = 0;
unsigned long diff = (unsigned long)(i + 2) - (unsigned long)i;
printf("%lx\n", diff);
```

The variable `i` is a pointer, so when we do `i + 2` we add 8 bytes to the address.
Converting this to unsigned long, we will see that the difference between the addresses is 8 bytes.

## Practical exercises

Task 1:

a) Look at the hello_world.c file from the handout code. Use GCC to produce an executable. Try executing the binary. What is the output of the program?

When not provided with any additional arguments, the output is "Hello World".

If command arguments are provided, the first one will be used as the name, and the output will be "Hello \[name\], nice to meet you!"

b) Compile the file crash.c. When you try to execute the file, you will see it output the message SEGFAULT. Please review the program to determine what it should output.
Use the installed debugging tools (GDB and Valgrind) to debug the program. Can you fix the program?

Using gcc with the `-Wall` option showed a warning regarding the size of the pointer used in the for loop in the main function.
I changed the condition to use the `elems` variable instead.

Task 2:

Write a program that takes a path to a directory as an optional argument.
If no argument is provided, figure out the current working directory. List the directory’s content in alphabetical order and print it out to `stdout`.
If you cannot list the directory due to missing permissions, the provided path points to a file, or the path does not exist, output an appropriate error message to `stderr`.

Check the file [show_path.c](./show_path.c) for the solution.
