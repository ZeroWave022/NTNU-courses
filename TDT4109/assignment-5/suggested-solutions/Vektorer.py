#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

import random
def make_vec():
    vec = []
    for i in range(3):
        vec.append(random.randint(-10,10))
    return vec
#b)

def vec_print(liste, name):
    print(name,"=",liste)
#c)

def vec_mult(liste, num):
    liste2 = []
    for el in liste:
        liste2 += [el*num]
    return liste2
#d)

def vec_len(vec):
    v_len = 0
    for el in vec:
        v_len += el**2
    v_len = v_len**0.5
    return v_len
#e)

def vector_dot_product(vec1,vec2):
    innerprod = 0
    for i in range(len(vec1)):
        innerprod += vec1[i]*vec2[i]
    return innerprod
#f)

def main():
    vec1 = make_vec()
    vec_print(vec1,"vec1")
    num = eval(input("Skriv inn en skalar: "))
    vec2 = vec_mult(vec1, num)
    v1_len = vec_len(vec1)
    v2_len = vec_len(vec2)
    print("Lengden før skalering er: %.2f"%v1_len)
    print("Lengden etter skalering er: %.2f"%v2_len)
    print("Forholdet mellom lengden før og etter skalering er:",end=" ")
    if v1_len==0:
        print("udefinert")
    else:
        print(v2_len/v1_len)
    print("Prikkproduktet av",vec1,"og",vec2,"er:",vector_dot_product(vec1,vec2))

