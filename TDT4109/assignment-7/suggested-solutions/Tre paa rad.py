#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

brett = [[' ',' ',' '],[' ',' ',' '],[' ',' ',' ']]
def print_Board():
    i = 1
    print("     1   2   3")
    for j in range(3):
        print("   -------------")
        print("",i,"|",brett[j][0],"|",brett[j][1],"|",brett[j][2],"|")
        i +=1
    print("   -------------")

#b)

def has_Won(x,y,merke):
    if brett[x][y] == merke and brett[(x+1)%3][y] == merke  and brett[(x+2)%3][y] == merke :
        return True
    elif brett[x][y] == merke and brett[x][(y+1)%3] == merke  and brett[x][(y+2)%3] == merke :
        return True
    elif brett[0][0] == merke and brett[1][1] == merke  and brett[2][2] == merke:
        return True
    elif brett[2][0] == merke and brett[1][1] == merke  and brett[0][2] == merke:
        return True
    return False

#c)

def get_Players():
    navn1 = input("Skriv inn navnet på spiller 1 (x): ")
    navn2 = input("Skriv inn navnet på spiller 2 (o): ")
    return navn1,navn2

#d)

def legal_Move(x,y):
    if brett[x][y] == ' ':
        return True
    else:
        return False

#e)

def get_Input(navn,merke):
    print(navn,"(",merke,")","sin tur.")
    z = input("Skriv inn ditt trekk; i,j: ")
    while True:
        if len(z)== 3 and(ord(z[2]) >= 49 and ord(z[2]) <=51) and ( ord(z[0]) >= 49 and ord(z[0]) <=51):
            y = int(z[2])-1
            x = int(z[0])-1
            if legal_Move(x,y):
                return x,y
            else:
                print("Ugyldig trekk!")
        else:
            print("Ugyldig input!")
        print(navn,"(",merke,")","sin tur.")
        z = input("Skriv inn ditt trekk; i,j: ")

#f)

brett = [[' ',' ',' '],[' ',' ',' '],[' ',' ',' ']]
def main():
    navn = get_Players()
    merke = ['x','o']
    print_Board()
    i = 0
    j = 0
    while True:
             x,y = get_Input(navn[i],merke[i])
             brett[x][y] = merke[i]
             if has_Won(x,y,merke[i]):
                 print_Board()
                 print("Spiller",navn[i], "har vunnet.\nGratulerer!")
                 return
             elif j == 8:
                 print_Board()
                 print("Det ble uavgjort!")
                 return
                 
             print_Board()
             i = (i+1)%2
             j += 1
main()

