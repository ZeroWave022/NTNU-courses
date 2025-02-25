#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#Oppgave a
def p_ig(t, v, n, rgas=8.31452):
    p = (n*rgas*t)/v
    return p
 
 
#Oppgave b
def p_ig_pptable(vols,temps, n):
    tab = []
    for i in range(len(vols)):
        vol = vols[i]
        tab.append([vol])
        for j in range(len(temps)):
            temp = temps[j]
            p = p_ig(temp, vol, n)
            tab[i].append(p)
    return tab
 
 
#Oppgave c
nv = 10     # number of volumes (rows) [-]
nt = 3      # number of temperatures (columns) [-]
 
n = 10      # [mol]
t = [100 + float(j)*200 for j in range(nt)]     # [K]
v = [10**(-float(i)/nv) for i in range(1, nv+1)]
 
table = p_ig_pptable(v,t,n)
 
print("| Volum (m^3)".ljust(21),"|",("Temp. = "+str(t[0])+"K").ljust(19),"|",("Temp. = "+str(t[1])+"K").ljust(19),"|",("Temp. = "+str(t[2])+"K").ljust(19),"|")
print("-"*89)
 
#SKRIV DIN KODE HER
for lst in table:
    print('|',end=' ')
    for el in lst:
        print(str(el).ljust(19),"|",end =' ')
    print("\n")

