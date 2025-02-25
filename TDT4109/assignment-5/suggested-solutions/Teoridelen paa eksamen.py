#!/usr/bin/env python
# coding: utf-8

# In[ ]:


fasit = ['A', 'C', 'B', 'D', 'A', 'A', 'B', 'A', 'C', 'A', 'D', 'A', 'C', 'C', 'B', 'A', 'B', 'A', 'C', 'D']
 
def sjekk_svar(svar):
  antall_korrekte = 0
 
  for i in range(len(svar)):
    if svar[i] == fasit[i]:
      antall_korrekte += 1
 
  return antall_korrekte / len(svar) * 100
 
print(sjekk_svar(['A', 'C', 'B', 'D', 'A', 'A', 'B', 'A', 'C', 'A', 'D', 'A', 'C', 'C', 'B', 'A', 'B', 'A', 'A', 'C'])) # Gir 90% riktig
print(sjekk_svar(fasit)) # Gir 100% riktig
print(sjekk_svar(['B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'])) # Gir 20% riktig

