#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


flyt1 = float(input("Skriv inn et flyttall: "))
flyt2 = float(input("Skriv inn enda et flyttall: "))
flyt3 = float(input("Skriv inn et siste flyttall: "))

print("Konvertert til heltall blir det", int(flyt1), int(flyt2), int(flyt3))

int1 = int(input("Skriv inn et heltall: "))
print("Konvertert til flyttall blir det:", float(int1))


# b)

# In[ ]:


navn = input("Skriv ditt navn: ")
alder = int(input("Hei, " + navn + ", hvor gammel er du? "))
alderProgStart = int(input("Hvor gammel var du da du startet å programmere? "))
progTid = alder - alderProgStart
print("Da har du programmert i", progTid, "år.")
svar = input("Syns du de " + str(progTid) + " årene har vært givende?")
print("Takk for svar,", navn)


# c)

# In[ ]:


print("Vennligst gi inn et flyttall med minst 5 siffer både før og etter .")
tall = float(input("Hva er tallet ditt? "))
heltall = int(tall)
print("Konvertert til heltall med int():", heltall)
print("Avrundet til nærmeste heltall:", round(tall))
print("Avrundet til to desimaler:", round(tall, 2))
print("Avrundet til fire desimaler:", round(tall, 4))
print("Avrundet til nærmeste tusen:", round(tall, -3))
print("Heltall fra int() konvertert tilbake til flyttall:", float(heltall))


# d)

# In[ ]:


flyttall = float(input("Skriv et flyttall: "))
antallDesimaler = int(input("Hvor mange deismaler er ønskelig? "))
print(
    "Tallet du skrev var",
    flyttall,
    "og med",
    antallDesimaler,
    "desimaler blir det til",
    round(flyttall, antallDesimaler),
)
