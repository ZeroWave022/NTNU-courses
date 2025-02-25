#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import binascii
import random
 
def toHex(word):
    return int(str(binascii.hexlify(word), 'ascii'), 16)
  
def toString(word):
    return str(binascii.unhexlify(hex(word)[2:]), 'ascii')
 
def encrypt(message,key):
    message = bytes(message, encoding = 'ascii')
    key = bytes(key, encoding = 'ascii')
    msg = toHex(message)
    key = toHex(key)
    code = msg ^ key
    return code
 
def decrypt(code,key):
    key = bytes(key, encoding = 'ascii')
    key = toHex(key)
    msg = code ^ key
    return toString(msg)
 
def main():
    key = 'abc'
    msg = 'hei'
    # Oppgave a
    code = encrypt(msg, key)
    print ('Krypto:', code)
    # Oppgave b
    message = decrypt(code, key)
    print('Melding:', message)
    # --------------------
    # Oppgave c
    msg = input('Hva er meldingen? ')
    key = ''
    """for ch in msg:               #Eventuell måte å få tilfeldig nøkkel på
        k = random.randint(65,90)
        k = toString(k)
        key += k"""
    charlst = list(msg)
    random.shuffle(charlst)
    key = ''.join(charlst)
    code = encrypt(msg,key)
    print("Krypto:",code)
    msg = decrypt(code,key)
    print("Melding:",msg)
 
main()


# d) Sjekk "Reused Key Attack": https://en.wikipedia.org/wiki/Stream_cipher_attack
# 
# [Ved å ta XOR på to meldinger M1 = A XOR C og M2 = B XOR C som er kryptert med samme nøkkel C finner man D = A XOR B.](https://en.wikipedia.org/wiki/Stream_cipher_attack)
# 
# Deretter kan man ved hjelp av en ordbok teste alle mulige kombinasjoner av tilsvarende lange ord, hvilke to ord som sammen gir D. Med moderne datamaskiner er dette gjort på få sekunder. 
# 
# 
