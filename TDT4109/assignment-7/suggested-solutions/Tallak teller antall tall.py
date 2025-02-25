#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a) 

#Alternativ 1
def number_of_lines(filename):
    fp = open ( filename , "r")
    i = 1
    for c in fp.read():
        if c == "\n":
            i += 1
    fp.close()
    return i

#Alternativ 2
def number_of_lines2(filename):
    fp = open(filename,'r')
    i = 0
    for line in fp. readlines ():
        i+=1
    fp.close()
    return i

#Alternativ 3
def number_of_lines3(filename):
   return len(open(filename).readlines())

#b)

def number_frequency ( filename ):
    freq = {}
    fp = open ( filename )
    for line in fp. readlines ():
        number = int ( line . strip ())
        freq [ number ] = freq . get(number , 0) + 1
    fp.close()
    return freq

#c)

for num, value in number_frequency("numbers.txt").items():
    print("%d: %d" % (num , value ))

