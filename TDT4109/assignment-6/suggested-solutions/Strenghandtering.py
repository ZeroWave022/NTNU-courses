#!/usr/bin/env python
# coding: utf-8

# In[ ]:


# a)
def check_equal(str1, str2):
    if len(str1) == len(str2):
        for i in range(len(str1)):
            if str1[i] != str2[i]:
                return False
        return True
    return False
 
#alternativ a)
def check_equal(str1, str2):
    return str1 == str2
  
# b)
def reversed_word(string):
    reversed = ''
    for i in range(len(string) - 1, -1, -1):
        reversed += string[i]
    return reversed
 
# c)
def check_palindrome(string):
    return string == reversed_word(string)
  
#alternativ c)
def check_palindrome(string):
    return check_equal(string,reversed_word(string))
 
# d)
def contains_string(str1, str2):
    ind = -1
    for x in range(len(str1)):
        if str1[x:(len(str2) + x)] == str2:
            ind = x
    return ind
  
#alternativ d)
def contains_string(str1,str2):
    return str1.find(str2)

