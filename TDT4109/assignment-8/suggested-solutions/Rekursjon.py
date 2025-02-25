#!/usr/bin/env python
# coding: utf-8

# a)

# In[1]:


def recursive_sum(n):
    if n == 1:
        return 1
    return n + recursive_sum(n - 1)


# b)

# In[8]:


def merge_sum(liste):
    if len(liste)==1:
        return liste[0]
    mid = len(liste)//2
    return merge_sum(liste[:mid])+merge_sum(liste[mid:])


# c)

# In[10]:


def find_smallest_element(liste, mini = float('inf')):
    if (liste[0] <= mini):
        mini = liste[0]
    if (len(liste) <2):
        return mini
    else:
        return(find_smallest_element(liste[1:len(liste)],mini))
  
#alternativt
def find_smallest_element(liste):
    if len(liste) == 1:
        return liste[0]
    else:
        min = find_smallest_element(liste[1:])
        if liste[0] < min:
            return liste[0]
        else:
            return min


# d)

# In[ ]:


def binary_search(numbers, element):
    if len(numbers) == 1 and element != numbers[0]:
            return -float('inf')
    middle_index = int(len(numbers)/2)
    middle_element = numbers[middle_index]
     
    if element == middle_element:
        return middle_index
    elif element > middle_element:
        return binary_search(numbers[middle_index:], element) + middle_index
    else:
        return binary_search(numbers[:middle_index], element)
    
#alternativt

def binary_search(liste, verdi, imin, imax):
    if(imax < imin):
        return False
    else:
        imid = (imin+imax)//2 # Midtpunktet
        if (verdi<liste[imid]):
            return binary_search(liste,verdi,imin,imid-1)
        elif (verdi>liste[imid]):
            return binary_search(liste,verdi,imid+1,imax)
        else:
            return imid

