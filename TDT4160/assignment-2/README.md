# TDT4160: Praktisk øving 2

> [!NOTE]
> Informasjonen er hentet direkte fra INGInious brukt i kurset.

I denne øvingen skal du skrive RISC-V-assembly. For å kjøre og teste koden bruker vi simulatoren Ripes. Du kan enten laste ned Ripes til din egen maskin, eller bruke online-simulatoren på [ripes.me](https://ripes.me/).

I Ripes velger du CPUen "Single Cycle Processor" eller "5-Stage processor". Pass også på å huke av for ISA Exts.-valget "M". Se dokumentet på Blackboard dersom du trenger hjelp med Ripes.

I denne øvingen skal du implementere funksjoner. I praksis betyr dette at du **ikke** kan bruke registeret som heter *x1 / ra*, da dette er retur-adressen. All andre registere står du fritt til å bruke.

For denne øvingen får du separate skjeletter for hver av de 3 oppgavene, og leverer også funksjonene separat. Lever gjerne så snart du har fullført første oppgave, for å sjekke at alt er som det skal før du fortsetter.

I alle oppgavene vil du få bruk for instruksjoner som leser fra eller skriver til minnet. Et eksempel på lesing og skriving til minne er gitt i funksjonen `increment`:

```asm
# Tar inn en adresse i a0, og øker tallet som ligger på adressen med 1.
# Tallet tolkes som et 32-bits tall, som starter på byte a0, til og med byte a0+3.
increment:
    # Leser inn et 32-bits tall fra adresse a0, med 0 i offset
    lw t0, 0(a0)
    # Øker tallet med 1
    addi t0, t0, 1
    # Skriver det økte tallet tilbake til minnet på adresse a0
    sw t0, 0(a0)
    # Forlater increment-funksjonen
    ret
```

Her kan du lese mer om: [lese- og skrive-instruksjoner](https://projectf.io/posts/riscv-load-store/).

Når du har implementert ferdig en funksjon trykker du "Run". Skjelettene inkluderer noen tester, som printer til konsollen om noe gikk galt. Hvis ikke printes det til konsollen at alle testene var vellykkede.

Når du laster opp løsningene dine vil koden testes på litt andre tester enn de du finner i skjelettet. Dersom koden din produserer feil svar på noen av testene vil du få beskjed om nøyaktig hvordan testen ser ut.

## Oppgave 1: Sum av liste (array)

I denne oppgaven skal du skrive en funksjon som summer opp tall fra en sammenhengende liste i minnet. Skjelettet til denne oppgaven finner du her: tdt4160-p2-1.S

Kopier KUN teksten innenfor det markerte området der du har skrevet din egen kode.

## Oppgave 2: Sum av lenket liste

I denne oppgaven skal du skrive en funksjon som summer opp tall fra en lenket liste i minnet. Skjelettet til denne oppgaven finner du her: tdt4160-p2-2.S

Kopier KUN teksten innenfor det markerte området der du har skrevet din egen kode.

## Oppgave 3: Flip liste i minnet (array)

I denne oppgaven skal du skrive en funksjon som snur rekkefølgen på en sammenhengende liste i minnet. Skjelettet til denne oppgaven finner du her: tdt4160-p2-3.S

Kopier KUN teksten innenfor det markerte området der du har skrevet din egen kode.
