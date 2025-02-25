#!/usr/bin/env python
# coding: utf-8

# In[ ]:


m = input("Måned: ")
d = int(input("Dag: "))
 
 
if m == 'mars':
    if d<20:
        print("Vinter")
    else:
        print("Vår")
elif m == 'juni':
    if d<21:
        print("Vår")
    else:
        print("Sommer")
elif m == 'september':
    if d<22:
        print("Sommer")
    else:
        print("Høst")
elif m == 'desember':
    if d<21:
        print("Høst")
    else:
        print("Vinter")
elif m == 'april' or m == 'mai':
    print("Vår")
elif m == 'juli' or m == 'august':
    print("Sommer")
elif m == 'oktober' or m == 'november':
    print("Høst")
else:
    print("Vinter")

