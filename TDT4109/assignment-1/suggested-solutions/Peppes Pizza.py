#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


pizza = 750
Studentrabatt = 0.20
Tips = 0.08


# b)

# In[ ]:


totalt = pizza*(1-Studentrabatt)*(1+Tips)
print("Total pris:",totalt)


# c)

# In[ ]:


antall = int(input("Hvor mange deltok på middagen? "))
prisPerPers = totalt/antall
print("Ettersom dere var",antall, "personer, så må hver person betale",
      prisPerPers, "kroner.")

