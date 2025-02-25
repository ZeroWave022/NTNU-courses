#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

print(cheeses['port salut'])

#b)

infected_cheeses = []
infected_shelves = ('A234', 'A235', 'B13', 'B14', 'B15', 'C31')
for cheese, shelves in cheeses.items():
    for shelf in shelves:
        prefix = shelf.split("-")[0]
        if prefix in infected_shelves and cheese not in infected_cheeses:
            infected_cheeses.append(cheese)
  
print('Potentially infected cheeses: ', infected_cheeses)

#c)

for cheese in cheeses.keys():
    if cheese not in infected_cheeses:
        for shelf in cheeses[cheese]:
            print (shelf.ljust(10), cheese)

