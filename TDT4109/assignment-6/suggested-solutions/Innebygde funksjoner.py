#!/usr/bin/env python
# coding: utf-8

# In[ ]:


# a)
import random
random_numbers = [random.randint(1,10) for i in range(100)]
 
# b)
print('Number of 2s:', random_numbers.count(2))
 
 
# c)
print('Sum of numbers:', sum(random_numbers))
 
 
# d)
random_numbers.sort()
print('Numbers sorted:', random_numbers)
 
 
# e)
count = 0
most = -1
for i in range(1,11):
    if random_numbers.count(i) > count:
        count = random_numbers.count(i)
        most = i
print ('There are most of number:', most)
 
 
# f)
random_numbers.reverse()
print('Numbers reversed:', random_numbers)

