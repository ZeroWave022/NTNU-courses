#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
def letters(s):
    for ch in s:
        print(ch)
 
#Oppgave b
def third_letter(s):
    if len(s)<3:
        return 'q'
    return s[2]
 
#Oppgave c
def length(s):
    return len(s)-1

