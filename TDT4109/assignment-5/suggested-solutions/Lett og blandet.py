#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

def isSixAtEdge(lst):
    return (lst[0] == 6 or lst[-1] == 6)
 

#b)

def average(lst):
    return sum(lst)/len(lst)
 


#c)

def median(lst):
    lst.sort()
    medianIndex = int((len(lst)-1)/2)
    return lst[medianIndex]

