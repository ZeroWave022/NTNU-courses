#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


tol = float(input("Skriv inn tol: "))
 
def funksjon_produkt(tol):
        count = 1
        prod = 1
        endring = prod*(1+(1/(count)**2)) - prod
        while endring > tol:
            prod = prod*(1+(1/(count)**2))
            count += 1
            endring = prod*(1+(1/(count)**2)) - prod
        return prod, count
 
print("Produktet ble %.2f etter %.d iterasjoner" %(mult(tol)))


# b)

# In[ ]:



def recursive_multi(tol, n = 1):
    new = 1 + math.pow(1.0/n, 2.0)
    if new > tol+1:
        return new * recursive_multi(tol, n+1)
    else:
        print("Rekursjonsdybden er", n-1)
        return new
 
print('Produktet ble:', format(recursive_multi(0.01),'.2f'))

