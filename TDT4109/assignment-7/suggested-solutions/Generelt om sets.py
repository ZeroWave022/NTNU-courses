#!/usr/bin/env python
# coding: utf-8

# In[1]:


#a)
my_set = set()


# In[ ]:


#b)
for x in range(20):
    if x%2==1:
        my_set.add(x)
print(my_set)


# In[ ]:


#c)
my_set2 = set()
for x in range(10):
    if x%2==1:
        my_set2.add(x)


# In[ ]:


#d)
my_set3 = my_set-my_set2


# In[ ]:


#e)
#0 ettersom jeg i d) lagde et set som ikke skulle inneholde noen av tallene fra c).
my_set4 = my_set3&my_set2
print(my_set4)         #printer set()


# In[ ]:


#f)
def allUnique(lst):
    return len(lst) == len(set(lst))


# In[ ]:


#g)
def removeDuplicates(lst):
    return list(set(lst))

