#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

  
def write_to_file(data):
    f = open('my_file.txt','w')
    f.write(data)
    f.close()
    
#b)

def read_from_file(filename):
    f = open(filename)
    data = f.read()
    print(data)
    f.close()
    
#c)

def main():
    choice = ''
    while choice != 'done':
        choice = input('Do you want to read or write? ')
        if choice == 'read':
            try:
                read_from_file('my_file')
            except:
                print('Oops, the file something went wrong when opening my_file.txt, try again')
                main()
        elif choice == 'write':
            data = input('What do you want to write to file? ')
            write_to_file(data)
            print(data, 'was written to file.')
    print('You are done.')
 
main()

