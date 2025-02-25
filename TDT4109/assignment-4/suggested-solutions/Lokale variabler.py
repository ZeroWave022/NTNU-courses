#!/usr/bin/env python
# coding: utf-8

# a) Kodesnutt 3 vil kjøre uten å krasje siden cakes-funksjonen som inneholder feilen aldri kalles. Dvs. at koden med feilen aldri blir prøvd kjørt, og dermed krasjer heller ikke programmet.
# 
# Feilen i kodesnutt 1: cake-variabelen i cakes-funksjonen blir definert etter at programmet har prøvd å kjøre kode som bruker den.
# 
# Feilen i kodesnutt 2: cakes-funksjonen prøver å bruke den lokale variabelen cupcake i cupcakes-funksjonen.
# 
# Feilen i kodesnutt 3: cake-variabelen blir aldri definert.
# 
# b)

# In[ ]:


def divide(x,y):
    num = x//y
    print("Heltallsdivisjon av",x,"over",y,"gir",num)
 
def square(x):
    num = x**2
    print("Kvadratet av",x,"er",num)


# c) Det vil ikke ha noen innvirkning på koden, siden begge num-variablene er lokale variabler i hver sin funksjon, og vil dermed ikke ha noen innvirkning på hverandre.
