#!/usr/bin/env python
# coding: utf-8

# a)
# 
# Syntaksfeilene i denne koden inkluderer et glemt kolon, at de to nederste linjene er innrykket feil, og flere feil med operatorer som skal være == (i stedet brukt =, ett sted = =)
# 
# Korrigert kode blir:

# In[ ]:


# leser inn data
prom = float(input("Hvor stor var promillen? "))
motor = input("Var farkosten en motorvogn? (j/n) ")
f = input("Var personen fører av vognen? (j/n) ")
leds = input("Var personen ledsager ved øvekjøring? (j/n) ")
n = input("Var det nødrett? (j/n) ")
  
# vurderer straffbarhet
if prom < 0.2 and motor == "j" and f == "j" or leds == "j" and n == "n":
   print("Det var straffbar promillekjøring.")
else:
   print("Ikke straffbart, ingen bot.")


# b) 
# 
# Den første feilen er at det står prom < 0.2, skulle ha stått prom > 0.2 når dette er i betingelsen for at det skal være straffbart.
# 
# Den andre feilen er relatert til operatorpresedens. Slik den sammensatte betingelsen i if-setningen står i utgangspunktet, vil Python først evaluere prom>0.2 and motor=="j", deretter leds=="j" and n=="n", og så ta or mellom disse to (or gjøres sist fordi den har lavest presedens). Med or er det nok at en av sidene er sann, dermed kan programmet komme til konklusjon straffbar hvis mistenkte var ledsager og det ikke var nødrett - helt uavhengig av hvilken verdi som er gitt for promille. Den enkleste og mest intuitive måten å fikse dette på er å sette parentes rundt (f=="j" or leds=="j") siden disse hører sammen - enten var man fører eller ledsager i bilen. Parentesene vil gjøre at dette blir evaluert først og deretter kombinert med and med resten av betingelsen. Med and må begge sider være sanne.

# In[ ]:


# leser inn data
prom = float(input("Hvor stor var promillen? "))
motor = input("Var farkosten en motorvogn? (j/n) ")
f = input("Var personen fører av vognen? (j/n) ")
leds = input("Var personen ledsager ved øvekjøring? (j/n) ")
n = input("Var det nødrett? (j/n) ")
  
# vurderer straffbarhet
if prom > 0.2 and motor == "j" and (f == "j" or leds == "j") and n == "n":
   print("Det var straffbar promillekjøring.")
else:
   print("Ikke straffbart, ingen bot.")


# c) 
# 
# En løsning her er å endre rekkefølge på betingelsene i if-elif-setningen. Når operatoren er >, bør den første betingelsen være den med høyest verdi, da vil situasjoner med lavere verdi fortsatt oppfanges av de neste betingelsene.

# In[ ]:


prom = float(input("Hvor stor var promillen? "))
if prom > 0.5:
    print("Bot: en halv brutto månedslønn, samt fengsel.")
elif prom > 0.4:
    print("Forelegg: 10000,-")
elif prom > 0.2:
    print("Forelegg: 6000,-")
else:
    print("Ikke straffbart, ingen bot.")


# En annen mulig løsning ville være å beholde verdiene i samme rekkefølge som de sto i det opprinnelige programmet, mens bruke motsatt operator (<=). Igjen er poenget at hvis den første betingelsen feiler, må det fortsatt være mulig å komme videre til de neste.

# In[ ]:


prom = float(input("Hvor stor var promillen? "))
if prom <= 0.2:
    print("Ikke straffbart, ingen bot.")
elif prom <= 0.4:
    print("Forelegg: 6000,-")
elif prom <= 0.5:
    print("Forelegg: 10000,-")
else:
    print("Bot: en halv brutto månedslønn, samt fengsel.")


# d) Problemet i den gitte koden var
# 
#  
# i) tidl == "j" er ikke i seg selv nok til å få inndratt førerkortet på livstid; det må skje en gjentatt promillekjøring. Første betingelse etter kommentaren #vurderer inndragning må derfor starte
# 
# ii) videre nedover er det satt opp som en serie frittstående if-setninger. Disse blir dermed vurdert hver for seg. Så med høy promille (f.eks. 1.3), vil programmet først skrive "...minst 2 år" men deretter fortsette med også å skrive 20-22 med, 18 mnd. osv. Løsningen her blir at det ikke må stå som frittstående setninger men i en if-elif-struktur. Med dette blir betingelsen prom>0.2 stående to steder, men første gang er det i sammenheng med at man er tidligere dømt, mens nederst vil det da være at det kun var snakk om promille > 0.2 uten noen andre komplikasjoner.

# In[ ]:


# leser inn data
prom = float(input("Hvor stor var promillen? "))
nekt = input("Nektet å samarbeide ved legetest? (j/n) ")
tidl = input("Tidligere dømt for promillekjøring? (j/n) ")
if tidl == "j":
    aar = int(input("Antall år siden siste domfellelse: "))
else:
    aar = 999
  
# vurderer inndragning av førerkort
if prom > 0.2 and tidl == "j" or nekt == "j" and aar < 5:
    print("Førerkort inndras for alltid.")
elif prom > 1.2 or nekt == "j":
    print("Førerkort inndras minst 2 år.")
elif prom > 0.8:
    print("Førerkort inndras 20-22 mnd.")
elif prom > 0.5:
    print("Førerkort inndras vanligvis 18 mnd.")
elif prom > 0.2:
    print("Førerkort inndras inntil 1 år.")
else:
    print("Ingen inndragning av førerkort.")


# e) Her er det flere måter å gjøre det på. De fleste av utfallene når det gjelder inndragning av førerkortet gjelder hvis det var promillekjøring, og må derfor befinne seg inni if-setningen som fastslår at det var et motorkjøretøy, at vedkommende var ansvarlig fører, at det ikke var nødrett. Samtidig må noen betingelser vedrørende nekting av legetest også testes selv om det ikke var promillekjøring, dvs. i else-delen nederst. Merk at nekt=="j" må være begge steder; hvis det var promillekjøring kan det utgjøre en forverrende omstendighet mhp inndragning av førerkort, og hvis det ikke var promille, kan det likevel føre til inndragning. Det er derfor vanskelig å få til her en løsning hvor man printer både bot og inndragning samme sted i if-strukturen. F.eks. kunne det ha vært fristende å printe både halv månedslønn og 18 med på samme betingelse prom > 0.5. Problemet med dette ville være at det fins situasjoner hvor en promille på f.eks. 0.6 likevel skal føre til mye lenger inndragning av førerkortet, nemlig hvis det var en gjentakelse, eller hvis man nektet å samarbeide ved legetest. Man måtte da evt. ha lagt til and tidl == "n" på hver eneste av disse testene. 
# 
# **Hele programmet**

# In[ ]:


# leser inn data
prom = float(input("Hvor stor var promillen? "))
motor = input("Var farkosten en motorvogn? (j/n) ")
f = input("Var personen fører av vognen? (j/n) ")
leds = input("Var personen ledsager ved øvekjøring? (j/n) ")
n = input("Var det nødrett? (j/n) ")
nekt = input("Nektet å samarbeide ved legetest? (j/n) ")
tidl = input("Tidligere dømt for promillekjøring? (j/n) ")
if tidl == "j":
    aar = int(input("Antall år siden siste domfellelse: "))
else:
    aar = 999
 
# vurderer straffbarhet
if prom > 0.2 and motor == "j" and (f == "j" or leds == "j") and n == "n":
    print("Det var straffbar promillekjøring.")
    # vurderer bot
    if prom > 0.5:
        print("Bot: en halv brutto månedslønn, samt fengsel.")
    elif prom > 0.4:
        print("Forelegg: 10000,-")
    else:
        print("Forelegg: 6000,-")
 
    # vurderer inndragning
    if tidl == "j":
        print("Førerkort inndras for alltid.")
    elif prom > 1.2 or nekt == "j":
        print("Førerkort inndras minst 2 år.")
    elif prom > 0.8:
        print("Førerkort inndras 20-22 mnd.")
    elif prom > 0.5:
        print("Førerkort inndras vanligvis 18 mnd.")
    else:
        print("Førerkort inndras inntil 1 år.")
else:
    print("Ikke straffbar promillekjøring, ingen bot.")
    # vurderer mulig inndragning selv om det ikke var straffbar kjøring
    if nekt == "j":
        print("Men da mistenkte slo seg vrang ved legetesten,")
        if aar < 5:
            print("<5 år etter en promilledom, inndras førerkort på livstid.")
        else:
            print("inndras førerkortet i 2 år.")

