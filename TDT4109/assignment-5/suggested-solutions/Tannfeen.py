#!/usr/bin/env python
# coding: utf-8

# In[ ]:


tenner = [95,103,71,99,114,64,95,53,97,114,109,11,2,21,45,2,26,81,54,14,118,108,117,27,115,43,70,58,107]
mynter_20 = 0
mynter_10 = 0
mynter_5 = 0
mynter_1 = 0
li = []
for tann in tenner :
  while tann > 0:
    if tann >= 20:
      tann -= 20
      mynter_20 += 1
    elif tann >= 10:
      tann -= 10
      mynter_10 += 1
    elif tann >= 5:
      tann -= 5
      mynter_5 += 1
    else:
      tann -= 1
      mynter_1 += 1
  print ("20:", mynter_20 , ", 10:", mynter_10 , ", 5:", mynter_5 , ", 1:",mynter_1)
  li.append([mynter_20,mynter_10,mynter_5,mynter_1])
  mynter_20 = 0
  mynter_10 = 0
  mynter_5 = 0
  mynter_1 = 0
print(li)


#Alternativ løsning:

tenner = [95,103,71,99,114,64,95,53,97,114,109,11,2,21,45,2,26,81,54,14,118,108,117,27,115,43,70,58,107]
 
li = []
mynter = [20,10,5,1]
for tann in tenner :
    li2 = []
    for mynt in mynter:
        li2.append(tann//mynt)
        tann -= mynt*(tann//mynt)       #evt. tann = tann%mynt
    print ("20:", li2[0], ", 10:", li2[1], ", 5:", li2[2], ", 1:", li2[3])
    li.append(li2)
print(li)

