#!/usr/bin/env python
# coding: utf-8

# a) absoluttverdi

# In[ ]:


# Skriv funksjonen din her
def absol(x):
   if x >= 0:
      svar = x
   else:
      svar = -x
   return svar
  
# skript for å teste funksjonen:
print("Absoluttverdien til 5 er", absol(5))
print("Absoluttverdien til -3 er", absol(-3))
print("Absoluttverdien til 0 er", absol(0))


# * Alternativt kan man også skrive return x og return -x direkte på if og else-alternativene.
# 
# b) knop til km/t

# In[ ]:


# skriv funksjonen din her
def knop_til_kmt(knop):
    m_sek = knop / 1.9438444924406
    km_t = m_sek * 3.6
    return km_t
 
# skript
knop = float(input("Oppgi fart i knop: "))
km_t = knop_til_kmt(knop)
print("Det blir", round(km_t, 2), "km/t")


# c) Imperial til cm

# In[ ]:


# skriv funksjonen din her
def imp2cm(ft, inch):
    inch = inch + ft * 12
    cm = inch * 2.54
    return round(cm)
 
# skript
fot = int(input("Oppgi antall fot: "))
tommer = int(input("Oppgi antall tommer: "))
cm = imp2cm(fot, tommer)
print("Det blir", cm, "cm")


# d) CMYK til RGB

# In[ ]:


# skriv funksjonen din her
def CMYK2RGB(C, M, Y, K):
    R = round(255 * (1-C) * (1-K))
    G = round(255 * (1-M) * (1-K))
    B = round(255 * (1-Y) * (1-K))
    return R, G, B
  
print("Oppgi farge i CMYK og få det konvertert til RGB.")
C = float(input("C: "))
M = float(input("M: "))
Y = float(input("Y: "))
K = float(input("K: "))
R, G, B = cmyk2rgb(C, M, Y, K)
print("Som RGB:", R, G, B)
  
# viser fargen på skjermen:
from turtle import colormode, bgcolor
colormode(255)
bgcolor(R, G, B)


# Denne løsningen kan gjøres litt penere ved å dele inn i flere funksjoner:

# In[ ]:


def CMYK2RGB(C, M, Y, K):
    R = round(255 * (1-C) * (1-K))
    G = round(255 * (1-M) * (1-K))
    B = round(255 * (1-Y) * (1-K))
    return R, G, B
 
def les_inn_CMYK():
    print("Oppgi farge i CMYK og få det konvertert til RGB.")
    C = float(input("C: "))
    M = float(input("M: "))
    Y = float(input("Y: "))
    K = float(input("K: "))
    return C, M, Y, K
  
def vis_farge(R, G, B):
    from turtle import colormode, bgcolor
    colormode(255)
    bgcolor(R, G, B)
  
def main():
    C, M, Y, K = les_inn_CMYK()
    R, G, B = cmyk2rgb(C, M, Y, K)
    print("Som RGB:", R, G, B)
    vis_farge(R, G, B)
  
main()

