#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Dette er én mulig måte å løse oppgaven på
import random
 
def main():
    dealer_c1 = draw_card()
    dealer_c2 = draw_card()
    vd = get_value(dealer_c1,dealer_c2)
    print("Dealers cards are",dealer_c1,"and ?")
    c1 = draw_card()
    c2 = draw_card()
    while True:
        vp = get_value(c1,c2)
        if is_Loss(c1,c2):
            print("You got:",vp)
            print("You lost")
            return
        print("Your score is:",vp)
        s = input("Do you want another card? (J/N) ")
        if s.upper() == 'J':
            c2 = vp
            c1 = draw_card()
            continue
        print("Dealers score is:",vd)
        if is_Win(vp,vd):
            print("You won!")
        else:
            print("You lost")
        break
 
def draw_card():
    c = random.randint(1,13)
    if c > 10:
        c = 10
    return c
 
def is_Loss(c1,c2):
    if get_value(c1,c2)>21:
        return True
    return False
 
def get_value(c1,c2):
    if c1 == 1 and c2 == 1:
        return c1+11
    if c1 == 1 and not c2+11>21:
        return c2+11
    if c2 == 1 and not c1+11>21:
        return c1+11
    return c1+c2
 
def is_Win(value_player,value_dealer):
    if value_dealer > 21 or value_player > value_dealer:
        return True
    return False
 
main()

