#!/usr/bin/env python
# coding: utf-8

# a) Løsning med sammensatt betingelse og nøstet if-setning:

# In[ ]:


pos = input("Posisjon: ")
 
bokstav = pos[0]
tall = int(pos[1])
 
if bokstav == 'a' or bokstav == 'c' or bokstav == 'e' or bokstav == 'g':
    if tall % 2 == 0:
        print("Hvit")
    else:
        print("Svart")
else:
    if tall % 2 == 0:
        print("Svart")
    else:
        print("Hvit")


# Den litt lange if-testen av fire ulike bokstaver vil kunne skrives enklere ved bruk av in-operatoren og en streng med alle aktuelle bokstaver:
# 
# if bokstav in 'aceg':                  (og resten av koden som før)
# 
#  
# 
# En enda mye kortere løsning kan imidlertid oppnås ved å utnytte bokstavenes ASCII-nummer, som finnes ved standardfunksjonen ord(). ord('a') har verdien 97, ord('b') 98, ord('c') 99, osv.
# 
# Vi merker oss at a1 er svart; 97+1 er 98, altså et partall. Mer generelt er det slik at alle ruter hvor summen av bokstavens ASCII-verdi og radens nummer er partall, vil være svarte, mens sum som er oddetall vil være hvite ruter.
# 
# Dette vil funke også for store bokstaver, siden ord('A) er 65, ord('B') 66, osv.
# 
# Løsning med ord()

# In[ ]:


pos = input("Posisjon: ")
 
bokstav = pos[0]
tall = int(pos[1])
  
# Svart rute: bokstavs ascii-verdi + radnummer blir partall
# Hvit rute: summen blir oddetall
if (ord(bokstav) + tall) % 2 == 0:
    print("Svart")
else:
    print("Hvit")


# b)

# In[ ]:


pos = input("Posisjon: ")
if len(pos) == 2:
    ch = pos[0]
    if ('A'<= ch <='H' or 'a' <= ch <='h') and '1'<=pos[1]<='8':
        #input OK
        tall = int(pos[1])
        if (ord(ch) + tall) % 2 == 0:
            print("Svart")
        else:
            print("Hvit")
    else:
        print("Feil input.")
        print("Første tegn må være en bokstav A-H eller a-h")
        print("Andre tegn må være et tall 1-8")
else:
    print("Feil lengde på input, skal være 2 tegn.")


# Her er det viktig at testen len(pos)==2 gjøres først. Hvis vi først prøver å teste bokstaver og tall ved å se på pos[0] og pos[1] vil dette feile i tilfelle bruker skrev inn null tegn (slo Enter med en gang).
# 
# Likeledes er det lurt å teste tegnet pos[1] mellom '1' og '8' heller enn å konvertere til  tall med int() og teste at tallet er mellom 1 og 8. Hvis bruker har skrevet noe annet enn et tall som andre tegn (f.eks. enda  en bokstav), vil int() komme til å feile.
# 
# Merk også at det trengs parentes rundt de to betingelsene som tester at vi er mellom A-H eller a-h. Dette fordi or har lavere presedens enn and. Hvis vi fjerner denne parentesen, vil testen i praksis bli
# 
# * at bokstaven - her variabelen ch - er mellom A-H
# * ELLER at bokstaven er mellom a-h og tallet mellom 1-8
# 
# Dvs. hvis det kommer stor bokstav vil vi da unnlate å teste på tallet, så A9 (f.eks.) vil  gå gjennom og gi svaret Svart, heller enn å gi feilmelding som det egentlig skulle.
