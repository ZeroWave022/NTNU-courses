#!/usr/bin/env python
# coding: utf-8

# In[ ]:


from sys import exit
  
antall_kvinner = 0
antall_menn = 0
antall_fag = 0
antall_ITGK = 0
antall_timer_lekser = 0
def skriv_statistikk ():
    print ("\nResultat av undersøkelse!")
    print (" Antall kvinner:", antall_kvinner )
    print (" Antall menn:", antall_menn )
    print (" Antall personer som tar fag:", antall_fag )
    print (" Antall personer som tar ITGK:", antall_ITGK)
    if antall_fag :
        print (" Antall timer i snitt brukt på lekser :",antall_timer_lekser / (antall_fag))
def sjekk_svar (spm):
    svar = input (spm ).strip().lower()
    if svar == "hade":
        skriv_statistikk()
        exit()
    return svar
def les_streng (spm):
    svar = ""
    while svar == "":
        svar = sjekk_svar ( spm)
    return svar
def les_ja_nei (spm):
    svar = ""
    while not ( svar == "ja" or svar == "nei"):
        svar = sjekk_svar ( spm)
    return svar == "ja"
def les_tall (spm):
    def sjekk_tall ( svar ):
            #Returnerer True hvis svar kan konverteres til et positivt heltall (uten +); False ellers
        if svar == "":
            return False
        for c in svar :
            if not (ord("0") <= ord(c) <= ord("9")):
                return False
        return True
    while True :
        svar = sjekk_svar ( spm)
        if sjekk_tall ( svar ):
            return int( svar )
while True :
    print ("\nVelkommen til spørreundersøkelsen!\n")
    kjønn = les_streng (" Hvilket kjønn er du? [f/m]: ")
    if not ( kjønn == "m" or kjønn == "f"):
        continue
    alder = les_tall (" Hvor gammel er du?: ")
    if alder < 16 or alder > 25:
        print("Du kan dessverre ikke ta denne undersøkelsen")
        continue
    antall_kvinner += ( kjønn == "f")
    antall_menn += ( kjønn == "m")
    fag= les_ja_nei (" Tar du et eller flere fag? [ja/nei ]: ")
    antall_fag += fag
    if not fag :
        continue
    if alder <  22:
        fag_ITGK = les_ja_nei (" Tar du ITGK? [ja/nei]: ")
    else:
        fag_ITGK = les_ja_nei (" Tar du virkelig ITGK?: ")
    antall_ITGK += fag_ITGK
    timer_lekser = les_tall (" Hvor mange timer bruker du daglig (i snitt) på lekser?: ")
    antall_timer_lekser += timer_lekser
    
#h) Nei. Tallene blir ikke lagret til fil og vil derfor ikke være tilgjengelig etter at programmet ditt er avsluttet.

