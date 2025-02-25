#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

poeng_2011 = open("poenggrenser_2011.csv").readlines()
 
def antall_studier_alle(grenser):
    i = 0
    for linje in grenser:
        grense = linje.strip().split(",")[1]
        if grense == '"Alle"':
            i += 1
    return i
  
print ('Antall studier hvor alle kom inn:', antall_studier_alle(poeng_2011))

#b)

def gjennomsnitt_opptak_NTNU(grenser):
    n = 0
    tot = 0
    for linje in grenser :
        tekst = linje.strip().split(",")
        studie = tekst[0]
        if studie[1:5] == 'NTNU':  # could also use: if 'NTNU' in studie:
            grense = tekst[1]
            if grense == '"Alle"':
                continue
            else:
                n += 1
                tot += float(grense)
    return tot/n
 
print ('Gjennomsnittlig opptaksgrense for NTNU var:', gjennomsnitt_opptak_NTNU(poeng_2011))

#c)

def laveste_opptaksgrense(grenser):
    laveste_studie = None
    laveste_grense = float('inf')
    for linje in grenser:
        studie, grense = linje.strip().split(",")
        studie = studie.strip ('"')
        if grense == '"Alle"':
            continue
        grense = float ( grense )
        if grense < laveste_grense :
            laveste_grense = grense
            laveste_studie = studie
    return laveste_studie
  
print ('Studiet som hadde den laveste opptaksgrensen var:', laveste_opptaksgrense(poeng_2011))

#d)

def studie_dictionary(linje):
    studie = {}
    linjenavn = linje.strip().split(" ")[2]
    opptakskrav = linje.strip().split(",")[1]
    if opptakskrav!="alle":
        linjenavn = linjenavn.split(",")[0]
    studie[linjenavn] = opptakskrav
    return studie
 
 
def organisert_dictionary(grenser):
    universitet = {}
    for linje in grenser:
        linje = linje.replace('"',' ')
        uni = linje.strip().split(" ")[0]
        if uni not in universitet:
            universitet[uni] = [studie_dictionary(linje)]
        else:
            universitet[uni].append(studie_dictionary(linje))
 
    for key, value in universitet.items():
        print(key, value)
organisert_dictionary(poeng_2011)

