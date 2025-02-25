#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


for x in range(5):
    for y in range(x+1):
        print(y+1, end=' ')
    print()


# b)

# In[ ]:


for x in range(5):
    print("#", end='')
    for y in range(x):
        print(' ', end='')
    print("#")


# c)

# In[ ]:


heltall = int(input("Skriv inn et positivt heltall: "))
tall = heltall                 # bruker en hjelpevariabel, ikke "ødelegge" brukerens tall
svar = ""                      # tom streng foreløpig, skal samle opp faktorene her
faktor = 2                     # starter med å prøve den laveste mulige faktoren
while tall >= 4:                # < 4 er definitivt et primtall
    while tall % faktor == 0:  # har funnet en faktor
        tall = tall // faktor  # reduserer tallet ved å dele vekk faktoren
        svar += str(faktor)    # putter faktoren inn i svarstrengen
        if tall > 1:           # fortsatt flere faktorer
            svar += "*"              # legger derfor til et gangetegn i svaret
    faktor += 1                # forrige faktor oppbrukt, øker med 1 for å prøve ny
if "*" in svar:                # har funnet et produkt av flere tall
    print(heltall, "=", svar)
else:
    print(heltall, "er et primtall")


# d)

# In[ ]:


import random
 
mer = 1
while mer:
    a = random.randint(0,9)
    b = random.randint(0,9)
    svar = a*b
    antall = 2
    for x in range(3):
        brukerInput = int(input('Hva blir '+str(a)+'*'+str(b)+'? '))
        if brukerInput==svar:
            print('Gratulerer, det er helt riktig!')
            break
        else:
            print('Dessverre ikke riktig. Du har',antall,'forsøk igjen.')
            antall-=1
            if antall <0:
                print('Dessverre klarte du ikke dette regnestykket, men vent så får du et nytt et:)')
     
    mer = int(input('Er det ønskelig med flere spørsmål? Skriv 1 for ja og 0 for nei: '))
    print()


# e)

# In[ ]:


import random
 
mer = 1
antallRette = 0
ovreGrense = 5
while mer:
    a = random.randint(0,ovreGrense)
    b = random.randint(0,ovreGrense)
    svar = a*b
    antall = 2
    for x in range(3):
        brukerInput = int(input('Hva blir '+str(a)+'*'+str(b)+'? '))
        if brukerInput==svar:
            print('Gratulerer, det er helt riktig!')
            antallRette +=1
            break
        else:
            print('Dessverre ikke riktig. Du har',antall,'forsøk igjen.')
            antall-=1
            if antall <0:
                antallRette = 0
                print('Dessverre klarte du ikke dette regnestykket, men vent så får du et nytt et:)')
     
    mer = int(input('Er det ønskelig med flere spørsmål? Skriv 1 for ja og 0 for nei: '))
    if antallRette%5==0 and antallRette>0:
        ovreGrense +=5
    print()

