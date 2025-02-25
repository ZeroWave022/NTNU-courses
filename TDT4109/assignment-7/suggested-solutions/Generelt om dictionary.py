#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)
my_family = {}
 
#b)
def add_family_member(role, name):
    my_family[role] = name
#c) 

my_family = {}
 
def add_family_member(role, name):
    if role not in my_family.keys():
        my_family[role] = [name]
    else:
        my_family[role].append(name)

