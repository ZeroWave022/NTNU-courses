#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
dager = int(input("Dager til du skal reise? "))
if dager >= 14:
    print("Du kan få minipris: 199,-")
else:
    print("For sent for minipris; fullpris 440,-")
    
#Oppgave b
dager = int(input("Dager til du skal reise? "))
if dager >= 14:
    print("Minipris 199,- kan ikke refunderes/endres")
    svar = input("Ønskes dette (J/N)? ")
    if svar == 'J' or svar == 'j':
        print("Takk for pengene, god reise!")
    else:
        print("Da tilbyr vi fullpris: 440,-")
else:
    print("For sent for minipris; fullpris 440,-")

#Oppgave c
pris = 440
mini = False
 
# deler beslutningen i to deler:
# 1) finne ut om det er minipris eller fullpris...
dager = int(input("Dager til du skal reise? "))
if dager >= 14:
    print("Minipris 199,- kan ikke refunderes/endres")
    svar = input("Ønskes dette (J/N)? ")
    if svar == 'J' or svar == 'j':
        print("Minipris valgt")
        mini = True
    else:
        print("Fullpris valgt")
else:
    print("For sent for minipris.")
 
# 2) regne ut pris, finne ut om det er noen rabatter 
if mini:
    pris = 199
else:
    alder = int(input("Alder: "))
    if alder < 16:
        pris = pris * 0.5
    elif alder >= 60:
        pris = pris * 0.75
    else:
        annet = input("Student / militær (J/N)? ")
        if annet.upper() == 'J':
            pris = pris * 0.75
print("Å betale:", pris)

#Oppgave d
pris = 440
mini = False
 
dager = int(input("Dager til du skal reise? "))
if dager >= 14:
    print("Minipris 199,- kan ikke refunderes/endres")
    svar = input("Ønskes dette (J/N)? ")
    if svar == 'J' or svar == 'j':
        print("Minipris valgt")
        mini = True
    else:
        print("Fullpris valgt")
else:
    print("For sent for minipris.")
 
stud = input("Student (J/N)? ")
if mini:
    pris = 199
    if stud.upper() == 'J':
        pris = pris * 0.9
else:
    if stud.upper() == 'J':
        pris = pris * 0.75
    alder = int(input("Alder: "))
    if alder < 16:
        pris = pris * 0.5
    elif alder >= 60:
        pris = pris * 0.75
    else:
        mil = input("Militær (J/N)? ")
        if mil.upper() == 'J':
            pris = pris * 0.75
print("Å betale:", pris)

