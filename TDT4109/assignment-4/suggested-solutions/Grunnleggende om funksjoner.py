#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


def siksak():
     print()
     print("**  **  **  **  **  **  **  **  **")
     print("  **  **  **  **  **  **  **  **")
     print() 
  
print("Data fra spørreundersøkelse")
siksak()
print("Del 1: ... div. data her, ikke vist")
siksak()
print("Del 2: ... mer data ...")
siksak()
print("Del 3: ... enda mer data ...")
siksak()
print("Del 4: ... ytterligere data ...")


# b) Løsningen her er definisjonen av superlativ() samt bruken av dette i en print midtveis, samt i kodefragmentet nederst. Disse tre er markert med ###

# In[ ]:


def komparativ(adj):
    # GROVT FORENKLET; BLIR MINST 20 LINJER
    if len(adj) >= 8: # unøyaktig
        svar = "mer " + adj
    else:
        svar = adj + "ere"
    return svar
 
def superlativ(adj):    ###
    if len(adj) >= 8:
        svar = "mest " + adj
    else:
        svar = adj + "est"
    return svar
 
#DEL AV KODEN HVOR SYSTEMET DISSER BRUKEREN
adj = input("Beskriv deg selv med et adjektiv: ")
print("Hah! Jeg er mye", komparativ(adj), "!")
print("Jeg er faktisk", superlativ(adj), "i hele verden!") ###
 
# DEL AV KODEN HVOR BRUKEREN TRENER PÅ Å GRADBØYE
adj = input("Skriv inn et adjektiv: ")
svar = input("Hva er komparativ for", adj, "? ")
fasit = komparativ(adj)
if svar == fasit:
    print("Korrekt!")
else:
    print("Feil, det var", fasit)
 
svar = input("Hva er superlativ for", adj, "? ") ### og videre nedover:
fasit = superlativ(adj)
if svar == fasit:
    print("Korrekt!")
else:
    print("Feil, det var", fasit)


# EKSTRAOPPGAVE: Gitt likheten i if-else delene for komparativ og superlativ, lager vi en funksjon tilbakemelding() som dekker begge disse.
# 
# Som man kan se, benytter denne funksjonen seg av print() som tutorial sa ofte ikke er lurt. Her er det dog greit, siden hovedpoenget med funksjonen tilbakemelding() nettopp er å kommunisere med brukeren.

# In[ ]:


def komparativ(adj):
    # GROVT FORENKLET; BLIR MINST 20 LINJER
    if len(adj) >= 8: # unøyaktig
        svar = "mer " + adj
    else:
        svar = adj + "ere"
    return svar
 
def superlativ(adj):
    if len(adj) >= 8:
        svar = "mest " + adj
    else:
        svar = adj + "est"
    return svar
 
def tilbakemelding(svar, fasit):
    if svar == fasit:
        print("Korrekt!")
    else:
        print("Feil, det var", fasit)
 
#DEL AV KODEN HVOR SYSTEMET DISSER BRUKEREN
adj = input("Beskriv deg selv med et adjektiv: ")
print("Hah! Jeg er mye", komparativ(adj), "!")
print("Jeg er faktisk", superlativ(adj), "i hele verden!")
 
# DEL AV KODEN HVOR BRUKEREN TRENER PÅ Å GRADBØYE
adj = input("Skriv inn et adjektiv: ")
svar = input("Hva er komparativ for", adj, "? ")
tilbakemelding(adj, komparativ(adj))
svar = input("Hva er superlativ for", adj, "? ")
tilbakemelding(adj, superlativ(adj))


# d)

# In[ ]:


def komparativ(adj):
    # GROVT FORENKLET; BLIR MINST 20 LINJER
    if len(adj) >= 8: # unøyaktig
        svar = "mer " + adj
    else:
        svar = adj + "ere"
    return svar
 
def superlativ(adj):
    if len(adj) >= 8:
        svar = "mest " + adj
    else:
        svar = adj + "est"
    return svar
 
def tilbakemelding(svar, fasit):
    if svar == fasit:
        print("Korrekt!")
    else:
        print("Feil, det var", fasit)
 
def main():
    #DEL AV KODEN HVOR SYSTEMET DISSER BRUKEREN
    adj = input("Beskriv deg selv med et adjektiv: ")
    print("Hah! Jeg er mye", komparativ(adj), "!")
    print("Jeg er faktisk", superlativ(adj), "i hele verden!")
    # DEL AV KODEN HVOR BRUKEREN TRENER PÅ Å GRADBØYE
    adj = input("Skriv inn et adjektiv: ")
    svar = input("Hva er komparativ for", adj, "? ")
    tilbakemelding(adj, komparativ(adj))
    svar = input("Hva er superlativ for", adj, "? ")
    tilbakemelding(adj, superlativ(adj))
 
main()

