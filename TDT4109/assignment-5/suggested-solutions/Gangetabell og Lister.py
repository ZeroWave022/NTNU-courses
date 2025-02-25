#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a) 

def separate(numbers, threshold):
    list1 = []
    list2 = []
    for i in numbers :
        if i < threshold :
            list1 . append (i)
        else:
            list2 . append (i)
    return list1 , list2

#b) 

def multiplication_table(n):
    multiplication_table = []
    for y in range (1, n + 1):
        row = []
        for x in range (1, n + 1):
            row.append(x * y)
        multiplication_table.append(row)
    return multiplication_table
 
print (multiplication_table(4))

