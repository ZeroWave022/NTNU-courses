#!/usr/bin/env python
# coding: utf-8

# a) og b)

# In[1]:


r = 5
print("Vi har en sirkel med radius", r)
omkrets = 2 * 3.14 * r
print("Omkretsen er", omkrets)
#b) print("Omkretsen er", format(omkrets, '.2f'))
areal = 3.14 * r**2
print("Arealet er", areal)
h = 8
volum = areal * h
print("Sylinder med høyde", h, ": Volumet er, volum")


# c)  Det skyldes at flyttall ikke lagres nøyaktig i Python.
