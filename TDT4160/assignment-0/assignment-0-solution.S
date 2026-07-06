# Denne filen inneholder skjelettet til Praktisk Øving 0 i faget TDT4160
# Kopier filen inn i Ripes-simulatoren, enten lokalt eller på ripes.me

# I Ripes velger du CPUen "Single Cycle Processor"

# I denne øvingen skal du skrive assembly som tar inn to tall, og regner ut summen
# Input ligger i registrene a1 og a2
# Output skal legges i register a0

# Setup av input
li a1, 7
li a2, 34

########################################################################################
######################## Skriv koden din under denne linja #############################
########################################################################################

# Her er løsningen, men den er kommentert ut!
add a0, a1, a2

########################################################################################
######################## Skriv koden din over denne linja ##############################
########################################################################################

# Print verdien i register a0 som et heltall
li a7, 1
ecall

# Exit med kode 0
li a7, 10
ecall
