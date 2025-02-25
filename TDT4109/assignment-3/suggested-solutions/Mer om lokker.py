#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


summen = 0
for i in range(7):
    tall = int(input("Skriv inn et heltall: "))
    summen += tall
print("Summen av tallene ble", summen)


# b)

# In[ ]:


prod = 1
number = 1
while prod < 1000:
    prod *= number    # ekvivalent med prod = prod*number
    number += 1
print(prod)


# c)
# 
# Siden vi ikke trenger brukerens svar til noe inni løkka, kan programmet kortest gjøres slik:

# In[ ]:



korrekt = "Alofi"
antall = 1
 
while korrekt != input("Hva er hovedstaden til Niue? "):
    print("Det var feil, prøv igjen.")
    antall += 1
print("Korrekt!! Du brukte", antall, "forsøk.")


# Hadde vi derimot trengt svaret inni løkka, f.eks. at vi i stedet for "Det var feil..." vil gi ekko av svaret i tilbakemeldingen til brukeren, må vi bruke en variabel og gjøre første input() før løkka som vist under. Bruk av variabel for svar er helt ok også om du ikke strengt tatt trenger det, mange kan syns koden blir litt vanskelig å lese med en input()-setning rett i while-betingelsen.

# In[ ]:


korrekt = "Alofi"
svar = input("Hva er hovedstaden til Niue? ")
antall = 1
 
while korrekt != svar:
    print(svar, "var feil, prøv igjen.")
    svar = input("Hva er hovedstaden til Niue? ")
    antall += 1
print("Korrekt!! Du brukte", antall, "forsøk.")

