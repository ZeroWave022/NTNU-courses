#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


import math
n = 4
r = 0.5
sum, i = 0,0
while True:
    sum += pow(r,i)
    i += 1
    if i > n:
        break
print ('Summen av rekken er', sum)


# b) og c)

# In[1]:


r = 0.5
s, i = 0, 0
tol = 0.001
limit = 2
 
while True:
    s += r**i
    i += 1
    if(limit - s <= tol):
        break
 
print("For å være innenfor toleransegrensen:", tol, ", kjørte løkken", i, "ganger")
print('Differansen mellom virkelig og estimert verdi var da', limit-s)

