#!/usr/bin/env python
# coding: utf-8

# In[1]:


#disse er bare eksempler på hvordan en kan tenke, oppgaven kan gjøres på vilt forskjellige måter.

#a, b, c, d

print("Du står ved enden av en vei, foran et hus med en lukket dør, det er en postkasse foran huset")
a = input("Hva gjør du?").lower()
if a == "går tilbake" or a == "går andre veien":
    print("Du snur deg og vandrer hjem igjen. Du kjøper en is på veien.")
elif a == "åpner døren" or a == "åpne døren":
    print("Døren er låst")
elif a == "åpner postkassen" or a == "åpne postkassen":
    print("Du finner en nøkkel i postkassen")
else:
    print("Ikke en støttet kommando")

