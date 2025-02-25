#!/usr/bin/env python
# coding: utf-8

# a) [9, 7, 5, 3, 2, 1]
# 
# Koden reverserer listen
# 
#  
# 
# b) [2, 3, 4, 7, 1, 5, 9, 8, 6, 10]
# 
# Koden randomiserer plasseringen av tallene 1-10 i en liste
# 
#  
# 
# c) [7]
# 
#  
# 
# d) 
# 
# Riktig kode:

# In[ ]:


navn = ['Carina', 'erik', 'Magnus', 'Miriam']
navn[1] = 'Erik'
print(navn)


# Det var vanlige parenteser og ikke hakeparenteser, altså var navn en tuppel (som er en ikke-muterbar sekvens).
# 
# En alternativ løsning er å bruke navn = list(navn) for å endre tuppelen navn til en liste navn:

# In[ ]:


navn = ('Carina', 'erik', 'Magnus', 'Miriam')
navn = list(navn)
navn[1] = 'Erik'
print(navn)


# e) [10, 9, 8, 7, 6, 5, 4, 3, 2]
