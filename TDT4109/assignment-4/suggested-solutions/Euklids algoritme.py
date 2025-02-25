#!/usr/bin/env python
# coding: utf-8

# In[ ]:


def gcd(a, b):
    while b != 0:       #kan også bruke 'while b:', siden betingelsen av et tall b blir sett på som True så lenge b!=0
        # a, b = b, a % b
        gammel_b = b
        b = a % b
        a = gammel_b
    return a
def reduce_fraction (a, b):
    divisor = gcd(a, b)
    return a / divisor , b / divisor
print ("%d/%d" % reduce_fraction (5, 10))
print ("%d/%d" % reduce_fraction (4, 2))
print ("%d/%d" % reduce_fraction (42 , 13))

