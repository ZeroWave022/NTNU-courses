#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


import math
h = 3
a = 3/math.sqrt(6)*h
areal = math.sqrt(3)*pow(a,2)
print("Et tetraeder med høyde",h,"har areal",areal)


# b)

# In[ ]:


import math
h = 3
a = 3/math.sqrt(6)*h
volum = 1/12*math.sqrt(2)*pow(a,3)
print("Et tetraeder med høyde",h,"har volum",volum)


# c)

# In[ ]:


import math
h = float(input("Skriv inn en høyde: "))
a = 3/math.sqrt(6)*h
areal = math.sqrt(3)*pow(a,2)
volum = 1/12*math.sqrt(2)*pow(a,3)
print("Et tetraheder med høyde",h,"har volum",round(volum,2),"og areal",round(areal,2),".")

