#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

def bubbleSort(liste):
    unsorted = 1
    while unsorted:
        unsorted = 0
        for x in range(0, len(liste)-1):
            if (liste[x] > liste[x+1]):
                liste[x], liste[x+1] = liste[x+1], liste[x]
                unsorted = 1
    return liste
  
liste = [9,1,34,7,2,3,45,6,78,56,36,65,33,21,23,34,45,6]
print(bubbleSort(liste))

#b)

def selectionSort(unSorted):
    sorted = [0 for x in range(0,len(unSorted))]
    for x in range(1, len(unSorted)+1):
        pos = unSorted.index(max(unSorted))
        sorted[-x] = unSorted[pos]
        unSorted.pop(pos)
    return sorted
 
 
liste = [9,1,34,7,2,3,45,6,78,56,36,65,33,21,23,34,45,6]
print(selectionSort(liste))

#c
#Selectionsort er best. Den utfører gjennomsnittlig færre operasjoner enn bubblesort selv om de er asymptotisk like gode.

