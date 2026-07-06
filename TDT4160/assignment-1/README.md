# TDT4160: Praktisk øving 1

> [!NOTE]
> Informasjonen er hentet direkte fra INGInious brukt i kurset.

I denne øvingen skal du skrive RISC-V-assembly.

For å kjøre og teste koden bruker vi simulatoren Ripes. Du kan enten laste ned Ripes til din egen maskin, eller bruke online-simulatoren på [ripes.me](https://ripes.me/).

Merk at kopiering ikke alltid fungerer i Safari. Dersom du har problemer, prøv f.eks. Chrome. Se forøvrig dokumentet på Blackboard dersom du trenger hjelp med Ripes.

Skjelettet for denne øvingen kan lastes ned her: tdt4160-p1.S. Det inneholder funksjoner du skal implementere. I alle tre funksjonene vil du få bruk for instruksjoner for hopping, med og uten betingelser.

To eksempler på bruk av hopp er gitt i funksjonen `min`:

```asm
# Tar inn to tall, i registerne a0 og a1
# Returnerer det minste tallet i registeret a0
min:
    # Hopp, men bare hvis a1 er "less than" a0
    blt a1, a0, a1_er_minst
    # Hvis vi kom hit betyr det at a1 >= a0
    # Det minste tallet ligger dermed allerede i a0
    # Hopp til slutten av funksjonen
    j min_ferdig

a1_er_minst:
    # Hvis vi er her detyr det at a1 < a0
    # Skriv a1 til a0
    mv a0, a1

min_ferdig:
    # På dette punktet vil det minste tallet ligge i a0
    # Forlater min-funksjonen
    ret
```

Funksjonen inneholder både et hopp med en betingelse (`blt`), og et ubetinget hopp (`j`). Her kan du lese mer om: [betingende hopp](https://projectf.io/posts/riscv-branch-set/) og [ubetingede hopp](https://projectf.io/posts/riscv-jump-function/).

Når du har implementert funksjonene i øvingen trykker du "Run". Skjelettet inkluderer noen tester, som printer til konsollen om noe gikk galt. Hvis ikke printes det til konsollen at alle testene var vellykkede.

## Oppgave 1: Lever besvarelsen din

Kopier KUN teksten innenfor det markerte området der du har skrevet din egen kode.
