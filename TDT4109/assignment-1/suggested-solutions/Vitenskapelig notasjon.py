#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


stoff = input("Si et stoff du er i besittelse av: ")
molvekt = float(input("Hva er molvekt i gram for "+stoff+"? "))
gram = float(input("Hvor mange gram har du? "))
mol = gram/molvekt
antall = mol*6.022e+23
print("Du har", format(antall, '.1e'), "molekyler "+stoff)


# b)

# In[ ]:


antallHørt = int(input("Antall ulike 10-toners melodilinjer du har hørt? "))
prosent = antallHørt/8.25e+19*100
print("Du har hørt", format(prosent, '.15e'), "av melodier som er mulig")

