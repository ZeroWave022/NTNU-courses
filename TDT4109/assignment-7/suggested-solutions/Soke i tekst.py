#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)
def read_from_file(filename):
    file = open(filename, 'r')
    text = file.read()
    file.close()
    return text
#b)

def remove_symbols(text):
   text = text.lower()
   return ''.join(letter for letter in text if letter.isalpha() or letter == ' ')
#c)

def countWords(filename):
    text = read_from_file(filename)
    clean_text = remove_symbols(text)
    words = clean_text.split()
    word_dict = {}
    for i in range(len(words)):
        if (words[i] in word_dict):
            word_dict[words[i]] += 1
        else:
            word_dict[words[i]] = 1
    return word_dict
#d) 

alice_dict = countWords('Alice_in_wonderland.txt')
for word, value in alice_dict.items():
    print(word, value)

