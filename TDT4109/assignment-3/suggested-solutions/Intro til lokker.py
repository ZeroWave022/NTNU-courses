#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


n = int(input("Hvor mange adjektiv vil du gi? "))
 
for i in range(n):
    adj = input("Beskriv deg selv med et adjektiv? ")
    print("Hah, du", adj + "!? Jeg er mye", adj + "ere!")
 
print("Takk for nå!")


# b)

# In[ ]:


print("Slå Enter uten å skrive noe for å slutte.")
adj = input("Beskriv deg selv med et adjektiv? ")
 
while adj != "":
    print("Hah, du", adj + "!? Jeg er mye", adj + "ere!")
    adj = input("Beskriv deg selv med et adjektiv? ")
 
print("Takk for nå!")


# c)
# 

# In[ ]:


bokst = 42
 
while bokst > 0:
    print("Du har", bokst, "bokstaver til disposisjon.")
    adj = input("Beskriv deg selv med et adjektiv? ")
    print("Hah, du", adj + "!? Jeg er mye", adj + "ere!")
    bokst = bokst - len(adj)
 
print("Takk for nå!")


# d)

# In[ ]:


print("Oddetallene fra 1 til 20:")
for number in range(1, 20, 2):
    print(number, end = " ")
print()
  
print("Tallene i 3-gangen mellom 12 og 25:")
for number in range(12, 25, 3):
    print(number, end = " ")
print()
  
print("Tallene i 5-gangen mellom 20 og 81:")
for number in range(20, 81, 5):
    print(number, end = " ")
print()
  
print("Tallsekvensen 48, 56, 64, 72, 80")
for number in range(48, 81, 8):
    print(number, end = " ")
print()
  
print("Telle baklengs fra 100 til 80, med intervall på -3, dvs. 100, 97, ...:")
for number in range(100, 80, -3):
    print(number, end = " ")
print()


# e)

# In[ ]:


for x in range(1,6):
    print(x)


# f)

# In[ ]:


for x in range(15, 0, -1):
    print(x)

