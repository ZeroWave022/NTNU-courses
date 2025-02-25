#!/usr/bin/env python
# coding: utf-8

# In[ ]:


a = float ( input ("a: "))
b = float ( input ("b: "))
c = float ( input ("c: "))
d = b**2 - 4*a*c
 
#Kode for å få rett fortegn/unngå dobbelt fortegn i utskrift. Må ikke ha dette.
if b<0:
    if c<0:
        print ("Andregradsligningen %.2f*x^2 %.2f*x %.2f har" % (a, b, c), end="")
    else:
        print ("Andregradsligningen %.2f*x^2 %.2f*x + %.2f har" % (a, b, c), end="")
else:
    if c<0:
        print ("Andregradsligningen %.2f*x^2 + %.2f*x %.2f har" % (a, b, c), end="")
    else:
        print ("Andregradsligningen %.2f*x^2 + %.2f*x + %.2f har" % (a, b, c), end="")
 
  
if d < 0.0:
    print (" to imaginære løsninger ")
elif d > 0.0:
    import math
    x1 = (-b+math.sqrt(d))/(2*a)
    x2 = (-b-math.sqrt(d))/(2*a)
    print (" de to reelle løsningene %.2f og %.2f"%(x1,x2))
else:
    x = -b/(2*a)
    print (" en reell dobbeltrot %.2f"%x)
 
 
  
  
#Stjerne-oppgaven:
a = float ( input ("a: "))
b = float ( input ("b: "))
c = float ( input ("c: "))
d = b**2 - 4*a*c
 
if b<0:
    if c<0:
        print ("Andregradsligningen %.2f*x^2 %.2f*x %.2f har" % (a, b, c), end="")
    else:
        print ("Andregradsligningen %.2f*x^2 %.2f*x + %.2f har" % (a, b, c), end="")
else:
    if c<0:
        print ("Andregradsligningen %.2f*x^2 + %.2f*x %.2f har" % (a, b, c), end="")
    else:
        print ("Andregradsligningen %.2f*x^2 + %.2f*x + %.2f har" % (a, b, c), end="")
 
if d < 0.0:
    print (" to imaginære løsninger ")
elif d > 0.0:
    import math
    if b <= 0:
        x1 = (-b+math.sqrt(d))/(2*a)
        x2 = c/(a*x1)
    else:
        x2 = (-b-math.sqrt(d))/(2*a)
        x1 = c/(a*x2)
    print (" de to reelle løsningene %.3e og %.3e"%(x1,x2))
else:
    x = -b/(2*a)
    print (" en reell dobbeltrot %.2f"%x)

