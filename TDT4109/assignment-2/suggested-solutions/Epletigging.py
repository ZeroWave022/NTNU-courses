#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
print("Dette er et program for å teste din sjenerøsitet.")
har = int(input("Hvor mange epler har du? "))
if har == 0:
    print("Æsj, det sier du bare for å slippe å gi noe!")
else:
    gir = int(input("Hvor mange kan du gi til meg? "))
    if gir < har / 2:
        print("Du beholder det meste for deg selv...")
    else:
        print("Takk, det var snilt!")
    print("Du har nå", har - gir, "epler igjen.")
  
#Oppgave b
print("Dette er et program for å teste din sjenerøsitet.")
har = int(input("Hvor mange epler har du? "))
if har == 0:
    print("Æsj, det sier du bare for å slippe å gi noe!")
else:
    gir = int(input("Hvor mange kan du gi til meg? "))
    if gir < har / 2:
        print("Du beholder det meste for deg selv...")
    else:
        print("Takk, det var snilt!")
    rest = har - gir
    if rest == 1:
        tekst = "eple"
    else:
        tekst = "epler"
    print("Du har nå", rest, tekst, "igjen.")
    
#Oppgave c
print("Dette er et program for å teste din sjenerøsitet.")
har = int(input("Hvor mange epler har du? "))
if har == 0:
    print("Æsj, det sier du bare for å slippe å gi noe!")
else:
    gir = int(input("Hvor mange kan du gi til meg? "))
    if gir < har / 2:
        print("Du beholder det meste for deg selv...")
    else:
        print("Takk, det var snilt!")
    rest = har - gir
    if rest >= 0:
        if rest == 1:
            tekst = "eple"
        else:
            tekst = "epler"
        print("Du har nå", rest, tekst, "igjen.")
    else:
        print("Du har nå 0 epler igjen. Gi meg de", -rest)
        print("du skylder meg neste gang vi møtes.")

