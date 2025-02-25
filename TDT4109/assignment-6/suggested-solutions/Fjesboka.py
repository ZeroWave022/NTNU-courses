#!/usr/bin/env python
# coding: utf-8

# In[ ]:


#a)

def add_data(str):
    user = str.split()
    user[2] = int(user[2])
    return user

#b)

def get_person(given_name, facebook):
    people = []
    for person in facebook:
        if person[0] == given_name:
            people.append(person)
    return people

#c)

def main():
    facebook = []
    user = ''
    name = ''
    print('Hello, welcometo Facebook. Add a new user by writing "given_name surname age gender relationship_status"')
     
    while True:
        user = input('Add a new user: ')
        if user == 'done':
            break
        facebook.append(add_data(user))
    print('Ok')
    while True:
        name = input('Search for a user: ')
        if name == 'done':
            break
        print(get_person(name, facebook))
main()

