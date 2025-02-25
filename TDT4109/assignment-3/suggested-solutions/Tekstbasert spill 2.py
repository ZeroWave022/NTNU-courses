#!/usr/bin/env python
# coding: utf-8

# In[3]:


#a
wrong_answer = True #her setter vi denne til True for å hoppe inn løkka
while wrong_answer:
    wrong_answer = False #alt annet enn gyldig svar vil hoppe ut av løkka
    print("Du står utenfor en dør.")
    a = input("Hva gjør du?").lower()
    if a == "går tilbake" or a == "gå andre veien":
        print("Du snur deg og vandrer hjem igjen. Du hører en skummel lyd og løper tilbake.")
    elif a == "åpner døren" or a == "åpner":
        print("Døren er låst")
    elif a =="bank på" or a == "banker på":
        print("Du får ingen respons")
    else:
        print("Det skjønte jeg ikke")
        wrong_answer = True


# In[ ]:


#b
door = False
while not door:
    print("Du står utenfor en dør.")
    a = input("Hva gjør du?").lower()
    if a == "går tilbake" or a == "gå andre veien":
        print("Du snur deg og vandrer hjem igjen. Du hører en skummel lyd og løper tilbake.")
    elif a == "åpner døren" or a == "åpner":
        print("Du går inn døren.")
        door = True
    elif a =="bank på" or a == "banker på":
        print("Du får ingen respons")
    else:
        print("Det skjønte jeg ikke")


# In[ ]:


#c og d
door = False
key = False
while not door:
    wrong_answer = False #alt annet enn gyldig svar vil hoppe ut av løkka
    print("Du står utenfor en dør.")
    a = input("Hva gjør du?").lower()
    if a == "går tilbake" or a == "gå andre veien":
        print("Du snur deg og vandrer hjem igjen. Du hører en skummel lyd og løper tilbake.")
    elif a == "åpner døren" or a == "åpner":
        if not key:
            print("Døren er låst")
        else:
            print("Du låser opp og går inn.")
            door = True
    elif a =="bank på" or a == "banker på":
        print("Du får ingen respons")
    elif a == "":
        break
    else:
        print("Det skjønte jeg ikke")


# In[2]:


#d

key = False
while door is False:
    print("Du står ved enden av en vei, foran et hus med en lukket dør, det er en postkasse foran huset")
    a = input("Hva gjør du?")
    if a.lower()=="":
        print("Bye bye")
        break
    elif a.lower()=="går tilbake":
        print("Du snur deg og vandrer hjem igjen. Du hører en skummel lyd og løper tilbake.")
    elif a.lower()=="åpner døren":
        if not key:
            print("Døren er låst")
        else:
            print("Du åpner døren og går inn")
            door = True
    elif a.lower()=="åpner postkassen":
        print("Du finner en nøkkel i postkassen")
        key = True
    else:
        print("Det skjønte jeg ikke")


# In[4]:


#b
door = False
key = False
flashlight = False
while door is False:
    print("Du står ved enden av en vei, foran et hus med en lukket dør, det er en postkasse foran huset")
    a = input("Hva gjør du? ")
    if a.lower()=="":
        print("Bye bye")
        break
    elif a.lower()=="går tilbake":
        print("Du snur deg og vandrer hjem igjen. Du finner en lommelykt i veikanten. Du hører en skummel lyd og løper tilbake.")
        flashlight = True
    elif a.lower()=="åpner døren":
        if not key:
            print("Døren er låst")
        else:
            print("Du åpner døren og går inn")
            door = True
    elif a.lower()=="åpner postkassen":
        print("Du finner en nøkkel i postkassen")
        key = True
    else:
        print("Det skjønte jeg ikke")
light = False
while not light:
    print("Du står i et mørkt rom. Du skimter en lysbryter på veggen")
    b = input("Hva gjør du? ")
    if b.lower() == "skrur på lysbryteren":
        print("Bryteren fungerer ikke")
    elif b.lower() == "bruker lommelykten":
        print("Du ser deg rundt i rommet og ser en skattekiste. Du tar alt gullet.")
        light = True
    elif a.lower()=="":
        print("Bye bye")
        break
    else:
        print("Det skjønte jeg ikke")
print("Gratulerer du vant spillet!")

