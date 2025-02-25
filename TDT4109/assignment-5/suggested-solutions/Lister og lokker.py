#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

number_list = [i for i in range(100)]
 

#b)

sum = 0
for number in number_list:
    if number % 3 == 0 or number % 10 == 0:
        sum += number
print(sum)
 

#c)

for i in range(0, len(number_list)-1,2):
    number_list[i], number_list[i+1] = number_list[i+1], number_list[i]
print(number_list)

#d)

reversed_list = []
for i in range(len(number_list)):
    reversed_list.append(number_list[99-i])
print(reversed_list)


#Alternativ løsning oppgave d)
reversed_list = []
for i in range(len(number_list)-1,-1,-1):
    reversed_list.append(number_list[i])
print(reversed_list)

