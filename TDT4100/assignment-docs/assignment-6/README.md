# Øving 06: Observatør-Observert og Delegering

## Øvingsmål

- Lære hva observatør-observert-teknikken er, dens bruksområder og fordeler
- Lære bruk av delegering for å utføre oppgaver i en klasse

## Øvingskrav

- Kunne definere og implementere et observatørgrensesnitt
- Kunne la en observert klasse fortelle dens observatører om endringer
- Kunne la en klasse delegere utførelsen av oppgaver til interne objekter

## Dette må du gjøre

### Del 1: Programmering

Denne øvingen omfatter både [delegeringsteknikken](https://www.ntnu.no/wiki/display/tdt4100/Delegeringsteknikken) og [observatør-observert-teknikken](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=66879660). Gjør **minst én** av de fire oppgavene under. For å få 2 poeng må det gjøres **minst én** oppgave fra **hvert av de to temaene**. Dette anbefales uansett på det *sterkeste*, siden dette må til for å dekke hele pensum.

Gjennomfør enten *minst én* av oppgavene om delegering:

- [The Office](./Office.md) (anbefalt) (Lett)
- [Logger](./Logger.md) (Medium)

ELLER *minst én* av oppgavene om observatør-observert-teknikken:

- [StockListener](./StockListener.md) (Medium)
- [Highscore](./HighscoreList.md) (Vanskelig)

**I tillegg til oppgaven(e) ovenfor skal du levere en tekstfil hvor du gjør kort rede for delegeringsteknikken og observatør-observert-teknikken.**

Delegeringsteknikken innebærer å ha en klasse som styrer over andre klasser. Her er det ofte slik at en klasse har "ansvar" over de andre.
Dette brukes ofte i situasjoner der man skal manage flere klasser av samme type og lignende. For eksempel kan en mananger ha ansvaret for flere ansatte.

Observatør-observert-teknikken brukes når vi ønsker å informere klasser om endringer som skjer i separate systemer.
Dette kan for eks. være at et mål ble scoret i en fotballkamp - dette kan skje når som helst, men vi ønsker for eks. å informere en fotballkamp-objektet og fotballspiller-objektene om dette.

### Del 2: Objektdiagram

For en av oppgavene du gjorde i del 1:

Lag en sekvens av kall i `main()`-metoden. Denne sekvensen må benytte seg av den passende teknikken fra del 1. Tegn deretter et [objektdiagram](https://www.ntnu.no/wiki/display/tdt4100/Objektdiagrammer) som viser tilstanden til hvert objekt ved slutten av `main()`-metoden. Du trenger ikke levere inn diagrammet på Blackboard.

## Hjelp / mistanke om bugs

Ved spørsmål eller behov for hjelp konsulter studassen din i saltidene hans/hennes. Du kan også oppsøke andre studasser på sal eller legge ut et innlegg på [Piazza](https://piazza.com/ntnu.no/spring2025/tdt4100).

## Godkjenning

Last opp kildekode på Blackboard innen den angitte innleveringsfristen. Innlevert kode skal demonstreres for en læringsassistent innen én uke etter innleveringsfrist. Se for øvrig Blackboard-sidene for informasjon rundt organisering av øvingsopplegget og det tilhørende øvingsreglementet.
