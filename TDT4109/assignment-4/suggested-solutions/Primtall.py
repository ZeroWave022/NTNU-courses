#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


def divisable(a,b):
    return (a%b==0)


# b)

# In[ ]:


def isPrime(a):
    for b in range(2,a):
        if divisable(a,b):
            return False
    return True


# c)

# In[ ]:


def isPrime2(a):
    if a == 2:
        return True
    if (divisable(a,2)):
        return False
    for b in range(3,round(pow(a,0.5)+0.5),2):
        if divisable(a,b):
            return False
    return True

