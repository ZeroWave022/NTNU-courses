#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

numbers = [x for x in range(1,35)]

#b)

myGuess = [5,7, 27, 13, 1, 2,11]

#c)

def drawNumbers(numbers,n):
    drawn = []
    import random
    for x in range(0,n):
        randNr = random.randint(0,len(numbers)-1) 
        drawn.append(numbers[randNr])
        numbers.pop(randNr)
    return drawn

#d)

def compList(listA, listB):
    matches = 0   
    for x in range(0,len(listA)):
        matches += listB.count(listA[x])==1
    return matches

#e)

def Winnings(num, eNum):
    if (num==7):
        return 2749455
    elif (num==6 and eNum >=1):
        return 102110
    elif (num == 6):
        return 3385
    elif (num == 5):
        return 95
    elif (num == 4 and eNum >= 1):
        return 45
    else:
        return 0

#f)

def main():
    numbers = [x for x in range(1,35)]   
    myGuess = [5,7, 27, 13, 1, 2,11]
    winningList = drawNumbers(numbers,10)
    mainNums = winningList[0:7]
    extraNums = winningList[7:10]
    correct = compList(mainNums, myGuess)
    extraCorrect = compList(extraNums,myGuess)
    won = Winnings(correct, extraCorrect)- 5 % Må huske å trekke fra prisen på kupongen
    return won

#g)

won = 0
for i in range(1000000):
    won += main()
print(won)

#Du går rundt 4 millioner i minus; ikke tipp lotto!

