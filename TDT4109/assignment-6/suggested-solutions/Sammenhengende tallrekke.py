#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

def randList(lenght,a,b):
    import random
    return [random.randint(a,b) for x in range(0,length)]

#b)

 def compareLists(listA, listB):
     common = []
     for a in listA:
         if a in listB and a not in common:
             common.append(a)
     return common
  
# alternativ løsning vha. set:
def compareLists1(listA, listB):
    return list(set(listA).intersection(set(listB)))

#c)

def multiCompList(lists):
    common = compareLists(lists[0], lists[1])
    for r in range(2,len(lists)):
        common = compareLists(common, lists[r])
    return common

#d)

def longestEven(list):
    ant = 0
    tempAnt = 0
    index = 0
    tempIndex = 0
    tempEven = 0
    for i in range(len(liste)):
            if (liste[i] % 2 == 0):
                    if tempAnt == 0:
                            tempIndex = i
                    tempAnt +=1
                    tempEven +=1
            else:
                    if tempAnt > ant:
                            ant = tempAnt
                            index = tempIndex
                    tempAnt = 0
    if tempEven == len(liste):
        ant = len(liste)
    return index, ant

