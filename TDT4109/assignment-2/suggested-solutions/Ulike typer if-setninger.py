#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#oppgave a
tid = int(input("Hvor mange minutt har kaken stått i ovnen? "))
if tid >= 50:
    print("Kaken kan tas ut av ovnen.")
print("Tips til servering: vaniljeis.")
 
  
#oppgave b
  
epler = int(input("Hvor mange epler har du? "))
barn = int(input("Hvor mange barn passer du? "))
if barn > 0:
    print("Da blir det", epler // barn, "epler til hvert barn")
    print("og", epler % barn, "epler til overs til deg selv.")
print("Takk for i dag!")
 
 
#oppgave c
alder = int(input("Skriv inn din alder: "))
 
if alder >= 18:
    print("Du kan stemme:)")
else:
    print("Du kan ikke stemme ennå")
  
  
#oppgave c
alder = int(input("Skriv inn din alder: "))
 
if alder >= 18:
    print("Du kan stemme både ved lokalvalg og Stortingsvalg.)")
elif alder >= 16:
    print("Du kan stemme ved lokalvalg men ikke ved Stortingsvalg.)")
else:
    print("Du kan ikke stemme ennå")
 
 
 
#oppgave e
alder = int(input("Din alder: "))
 
if alder < 3:
    print("Billetten er gratis")
elif alder < 12:
    print("Billettpris: 30kr")
elif alder < 26:
    print("Billettpris: 50kr")
elif alder < 67:
    print("Billettpris: 80kr")
else:
    print("Billettpris: 40kr")

