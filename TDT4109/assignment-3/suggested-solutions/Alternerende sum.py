#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
n=int(input("n=: "))
summen=0
for a in range(1,n+1):
    if a%2==0:
        summen-= a**2
    else:
        summen+= a**2  
print("Summen av tallserien er",summen)
 
#oppgave b
k = int( input ("k = "))
s = 0
i = 1
while True :
    new_s = s + ((-1)**(i+1) * i**2)      #(-1)**(i+1) gjør at alle ledd som er partall blir negative
    if new_s > k:
        break                             #break gjør at løkken avsluttes
    s = new_s
    i += 1
print ("Summen av tallene før summen blir større enn k er %d. Antall iterasjoner: %d" % (s, i-1))

