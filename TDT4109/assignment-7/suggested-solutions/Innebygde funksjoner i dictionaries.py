#!/usr/bin/env python
# coding: utf-8

# a)
# 1. [88, 92, 100]
# 2. 100

# In[1]:


#b)
fruit = {}
fruit['epler'] = 3
fruit['pærer'] = 4
fruit['appelsiner'] = 5


# In[ ]:


#c)
fruit['bananer'] = 0
fruit['druer'] = 1
del fruit['epler']
del fruit['pærer']
del fruit['appelsiner']


# In[2]:


#d)
for val in fruit.values():
    print(val)


# In[ ]:


#e)
if 'bananer' in fruit:
    del fruit['bananer']


# In[ ]:


#f)
fruit['jordbær'] = 6
fruit['blåbær'] = 50
  
for key, value in fruit.items():
    print(key, value)

