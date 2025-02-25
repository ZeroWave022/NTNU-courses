#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

print ("""INFO
Dette programmet besvarer om din utleie av egen bolig er skattepliktig.
Først trenger vi å vite hvor stor del av boligen du har leid ut.
Angi dette i prosent, 100 betyr hele boligen, 50 betyr halve,
20 en mindre del av boligen som f.eks. en hybel.
----------------------------------------------------------------------
DATAINNHENTING:""")
rentShare = int(input("Oppgi hvor mye av boligen som ble utleid: "))
rentIncome = int(input("Skriv inn hva du har hatt i leieinntekt: "))
print("\n----------------------------------------------------------------------")
print("SKATTEBEREGNING:")
if (rentShare <= 50) or (rentIncome <= 20000):
    print("Inntekten er ikke skattepliktig")
else:
    print("Inntekten er skattepliktig")
    print("Skattepliktig beløp er " + str(rentIncome))
    
#b) 

print("""INFO
Dette programmet besvarer om din utleie en annen type bolig,
her sekundær- eller fritidsbolig, er skattepliktig.
Først trenger vi å vite om du leier ut en sekundær- eller en fritidsbolig.
---------------------------------------------------------------------
DATAINNHENTING:""")
propertyType = input("Skriv inn type annen bolig (Sekundærbolig/Fritidsbolig) du har leid ut: ")
print("INFO")
if (propertyType == "Sekundærbolig"):
    print("Du har valgt sekundærbolig.")
    rentIncome = int(input("Skriv inn inntekt på sekundærboligen: "))
    print("Skattepliktig beløp er " + str(rentIncome))
elif (propertyType == "Fritidsbolig"):
    print("""Du har valgt fritidsbolig.
    Nå trenger vi først å vite om fritidsboligen(e) primært brukes til utleie eller fritid.
    Deretter trenger vi å vite hvor mange fritidsbolig(er) du leier ut.
    Til slutt trenger vi å vite hvor store utleieinntekter du har pr. fritidsbolig.
    \n---------------------------------------------------------------------
    DATAINNHENTING:""")
    propertyUsageType = input("Skriv inn formålet med fritidsboligen(e): ")
    numberOfProperties = int(input("Skriv inn antallet fritidsboliger du leier ut: "))
    incomePerProperty = int(input("Skriv inn utleieinntekten pr. fritidsbolig: "))
    print("\n---------------------------------------------------------------------")
    print("SKATTEBEREGNING:")
    if (propertyUsageType == "Fritid"):
        if(incomePerProperty<=10000):
            print("Inntekten er ikke skattepliktig")
        else:
            print("Inntekten er skattepliktig")
            taxBasePerProperty = incomePerProperty - 10000
            print("Overskytende beløp pr. fritidsbolig er " + str(taxBasePerProperty))
            taxPerProperty = int(0.85*taxBasePerProperty)
            print("Skattepliktig beløp pr. fritidsbolig er " + str(taxPerProperty))
            print("Totalt skattepliktig beløp er " + str(numberOfProperties*taxPerProperty))
    else:
        print("Inntekten er skattepliktig")
        print("Totalt skattepliktig beløp er " + str(numberOfProperties*incomePerProperty))
else:
    print("Du har skrevet inn en ugyldig boligtype.")
    
#c)

#Vi lar denne være opp til studenten. Ideelt sett kombinerer vedkommende if-setningene fra ovenstående kode 
#til et stort, helhetlig skript. Første nøkkelbetingelse blir hvorvidt boligen er en primærbolig eller en 
#sekundær-/fritidsbolig. 

