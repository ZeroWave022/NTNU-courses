#!/usr/bin/env python
# coding: utf-8

# In[ ]:


hemmelig_ord = input('Skriv inn det hemmelige ordet: ')
antall_liv = int(input('Hvor mange forsøk får brukeren? '))
 
while True:
    bokstav = input('Gjett på én bokstav i ordet: ')
    if bokstav in hemmelig_ord:
        print ('Stemmer, bokstaven er i ordet')
    else:
        antall_liv -= 1
        print ('Bokstaven', bokstav, 'er ikke i ordet.')
        if antall_liv > 0:
            print ('Du har ', antall_liv, 'liv igjen, prøv på nytt.')
        else:
            print ('Du har ingen liv igjen.')
            break

