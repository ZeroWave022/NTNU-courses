#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


print(input("Navn? "), "- fint navn!")
print(input("Favorittfag? "), "- interessant!")


# b)

# In[ ]:


navn = input("Navn? ")
print("Hei,", navn)
fag = input("Favorittfag? ")
print(fag, "- interessant!")
print("Ha en fin dag,", navn)
print("- og lykke til med", fag)


# c)

# In[ ]:


import math
   
r = 5.4
h = 7.9
print("Har en sirkel med radius", r, "som er grunnflate i en sylinder med høyde", h)
omkrets = math.tau * r
print("Omkrets av sirkelen:", omkrets)  #tau er det samme som 2 pi
areal_sirkel = math.pi * r**2
print("Areal av sirkelen:", areal_sirkel)
areal_sylinder = omkrets * h + 2 * areal_sirkel
print("Areal av sylinderen:", areal_sylinder)


# d)

# In[ ]:


fornavn = "Per"
ideal_alder = 42
kundensAlder = 37
differanse = ideal_alder - kundensAlder
print(fornavn, "er", differanse, "år unna idealalderen")

