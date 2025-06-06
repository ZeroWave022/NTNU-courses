# Arv - CardContainerImpl-oppgave

Denne oppgaven handler om å lage en felles superklasse `CardContainerImpl` for `CardDeck`- og `CardHand`-klassene, laget i [Card-oppgaven](../oving4/Card.md) og [CardContainer-oppgaven](../oving5/CardContainer.md). Dersom du ikke har gjort `Card`-oppgavene allerede, bør du gjøre disse først. Hvis du ikke har gjort det, kan du kopiere koden fra [løsningsforslaget](https://git.ntnu.no/tdt4100/tdt4100-lf-25/blob/main/src/main/java/oving5/card), som kommer til å være tilgjengelig etter siste demonstrasjonsfrist for øving 5.

Filene i denne oppgaven skal legges i [oving7/card](../../src/main/java/oving7/card).

## Del 1 - Superklassen CardContainerImpl

Lag en `CardContainerImpl`-superklasse, som implementerer grensesnittet `CardContainer` (se [CardContainer-oppgaven](../oving5/CardContainer.md)) og inneholder koden som er felles for `CardDeck` og `CardHand`.

La `CardDeck` og `CardHand` arve `CardContainerImpl` og gjør nødvendige endringer i disse klassene, slik at totaloppførselen er som før. F.eks. skal `CardDeck`-objektet ha samme konstruktør som før, som skal sikre samme initielle tilstand (men ikke nødvendigvis med samme konstruktør-kode).

Merk at målet er at mest mulig kode skal flyttes til _superklassen_ og gjenbrukes i _subklassene_. Det er viktig å bruke innkapsling rett (hint: `protected`-modifikatoren) for å nyttiggjøre seg superklassen i størst mulig grad.

## Del 2 - Regler for maksimalt antall kort

Anta at en ønsker å unngå at instanser av `CardContainerImpl` (eller av en av subklassene) inneholder for mange kort. Legg til et _privat_ `maxCardCount`-felt i `CardContainerImpl`, en konstruktør som _initialiserer_ feltet og en _getter_ for å lese verdien. Legg så til evt. endre kode i `CardContainerImpl` som sikrer at antall kort ikke overstiger dette tallet og at subklassene ikke kan omgå denne valideringen.

`CardContainerImpl`-subklassene `CardDeck` og `CardHand` skal sette maks-antallet som følger: `CardDeck` skal sette makstallet til _52_ og `CardHand` skal ta inn maks-antallet i _sin_ konstruktør. Hvis man forsøker å legge til flere kort enn hva som er tillatt i `CardHand`, skal det utløses en `IllegalStateException`.

Testkode for oppgavene finner du her: [oving7/card/CardDeckTest.java](../../src/test/java/oving7/card/CardDeckTest.java) og [oving7/card/CardHandTest.java](../../src/test/java/oving7/card/CardHandTest.java).
