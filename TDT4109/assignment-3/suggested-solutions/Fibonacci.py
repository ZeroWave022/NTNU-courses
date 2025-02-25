#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


n = 13
fib, fib_next = 0,1
if n==0:
    print(fib)
elif n==1:
    print(fib_next)
else:
    for i in range(2,n+1):
        fib, fib_next = fib_next , fib+fib_next   
    print(fib_next)


# b)

# In[ ]:


n = 13
fib, fib_next = 0,1
sum = 0
if n==0:
    sum = fib
    print(fib)
elif n==1:
    sum = fib + fib_next
    print(fib_next)
else:
    for i in range(2,n+1):
        fib, fib_next = fib_next , fib+fib_next
        sum += fib
    sum +=fib_next
    print(fib_next)
print(sum)


# c)

# In[ ]:


n = 13
fibliste = [0,1]
if n==0:
    print(fibliste[0])
else:
    for i in range(2,n+1):
        fibliste.append(fibliste[i-1]+fibliste[i-2])
    print(fibliste)

