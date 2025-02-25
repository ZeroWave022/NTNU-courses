#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import random
 
a = int(input("Gi en nedre grense for det randome tallet: "))
b = int(input("Gi en øvre grense for det romdome tallet: "))
TilfeldigTall = random.randint(a, b)
riktig=False
while riktig==False:
    guess = int(input("Make a guess "))
    if guess==TilfeldigTall:
        riktig = True
    elif guess < TilfeldigTall:
        print("The correct Number is higher")
    else:
        print("The correct number is lower")
print("You guessed correct!")

