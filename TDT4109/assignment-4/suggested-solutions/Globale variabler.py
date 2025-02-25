#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#######
# Del A
#######
  
GRAVITY = 9.81
 
def get_fall_time(distance):
  return math.sqrt(2 * distance / GRAVITY)
 
def main():
  distance = int(input('Antallet meter objektet skal ramle: '))
  time = get_fall_time(distance)
  print('Det tar', time, 'sekunder å ramle', distance, 'meter')
 
if __name__ == "__main__":
  main()
 
 
#######
# Del B
#######
  
# Angående den gitte løsningen på problemet, står en liten diskusjon angående dette i tutorialen på toppen av siden.
  
# Endre funksjonen i forrige oppgave til noe som ligner dette
  
def get_fall_time(distance, gravity=GRAVITY):
  return math.sqrt(2 * distance / gravity)

