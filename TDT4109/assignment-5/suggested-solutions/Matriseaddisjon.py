#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import random
def random_matrise(bredde, høyde):
    matrise = [[random.randint(0,9) for j in range(bredde)] for i in range(høyde)]
    return matrise
 
 
def print_matrise(matrise, navn):
    print(navn+'=[')
    for rad in matrise:
        print((len(navn)+1)*' ',rad)
    print(len(navn)*' ',']')
 
def matrise_addisjon(a, b):
    if len(a)==len(b) and len(a[0])==len(b[0]):
        matrise = [[0 for j in range(len(a[0]))] for i in range(len(a))]
        for x in range(len(matrise)):
            for y in range(len(matrise[0])):
                matrise[x][y] = a[x][y] + b[x][y]
        return matrise
    else:
        print("Matrisene er ikke av samme dimensjon")
  
def main():
    A = random_matrise(4,3)
    print_matrise(A, 'A')
    B = random_matrise(3,4)
    print_matrise(B, 'B')
    C = random_matrise(3,4)
    print_matrise(C, 'C')
    D = matrise_addisjon(A,B)
    E = matrise_addisjon(B,C)
    print_matrise(E, 'B+C' )
     
                    
main()

