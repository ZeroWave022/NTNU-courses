#!/usr/bin/env python
# coding: utf-8

# In[1]:


#Oppgave a
def newString(streng):
    return streng[::4]
 
#Oppgave b
def newString(liste):
    s = ""
    for st in liste:
        s += st[-2:]
    return s


# c) Kodesnutt 2 er korrekt, og vil skrive ut 'Cake'. Dette fordi man kan bruke negative verdier for å vise til plassering i en streng. I tillegg, selv om 100 er mye større enn lengden av strengen, vil Python bruke lengden til strengen som end istedet for å utløse et unntak.
# 
# Feilen i kodesnutt 1: streng[7:] = "Cupcake"
# Prøver her å endre på strengen, noe som ikke er mulig siden strenger er ikke-muterbare.
# 
# Feilen i kodesnutt 3: streng = streng[ ]
# Dette vil gi syntaksfeil.
