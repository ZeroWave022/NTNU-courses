#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
def substrings(str1,str2):
    inds = []
    i = 0
    str3 = str2
    while str3.lower().find(str1.lower())>-1:
        i += str3.lower().find(str1.lower())
        inds.append(i)
        str3 = str2[i+1:]
        i += 1
    return inds
 
 
#Oppgave b
def change_substrings(str1,str2,str3):
    indexes = substrings(str1,str2)
    newString = ""
    l = len(str1)
    i = 0
    for ind in indexes:
        ind -= i
        if ind<0:
            newString += str2[:ind+l-1]+str3
        else:
            newString += str2[:ind]+str3
        str2 = str2[ind+l:]
        i += l+ind
    return newString+str2

