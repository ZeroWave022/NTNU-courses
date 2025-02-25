#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


ant_stud = int(input("Hvor mange studenter? "))
ant_emner = int(input("Hvor mange emner? "))
for x in range(1, ant_stud+1):
    for y in range(1, ant_emner+1):
        print("Stud", x, "elsker Emne", y, end=" ; ")
    print()


# EKSTRAOPPGAVE (her er selvsagt andre valg for personnavn, emnenavn og verb m.m. mulig):

# In[ ]:


from random import random
 
stud = ['Ada', 'Grace', 'Guido', 'Linus', 'Runa']
emner = ['Ex.phil.', 'Ex.fac.', 'Matte', 'ITGK']
for st in stud:
    print(st, end = " ")
    for em in emner:
        tall = random()
        if tall > 0.9:
            verb = 'elsker'
        elif tall > 0.6:
            verb = 'digger'
        elif tall > 0.3:
            verb = 'liker'
        else:
            verb = '"liker"'
        print(verb, em, end = "; ")
    print()


# b)
# 
# "Rett fram"-løsning på denne er en dobbel løkke med print() i den innerste. Dette programmet vil imidlertid gå fryktelig tregt:

# In[ ]:


for x in range(24):
    for y in range(60):
        print(x + ":" + y)


# Årsaken til høyt tidsforbruk er at print ut på skjermen er tidkrevende. Hvis man ønsker et raskere program vil det derfor lønne seg å printe færre ganger, og da skrive større bolker av tekst hver gang. Mest ekstremt kan man samle opp alt som skal printes i en stor streng som man skriver ut når den doble løkka er ferdig:

# In[ ]:


ut_streng = ""
for x in range(24):
    for y in range(60):
        ut_streng += str(x) + ":" + str(y) + "\n"
        # "\n" er linjeskift
print(ut_streng)


# Dette vil gå mye raskere enn den første versjonen.
# 
# Men hva om man heller ville at det skulle gå tregere, at nytt klokkeslett skal vises når det ha gått akkurat et minutt? I så fall må den første versjonen brukes, med tillegg av kode for å vente et minutt mellom hver utskrift:

# In[ ]:


import time
  
for x in range(24):
    for y in range(60):
        print(x + ":" + y)
        time.sleep(60)


# I tillegg kan du evt. google deg fram til andre funksjoner i time-modulen som kan brukes til å få programmet til å starte med nåtidspunktet, heller enn på 0:0.
# 
# c)

# In[ ]:


for x in range(1, 11):
    for y in range(1, 11):
        print(x*y)
  
#finere utskrift:
for x in range(1, 11):
    for y in range(1, 11):
        print(x*y, end=' ')
    print()

