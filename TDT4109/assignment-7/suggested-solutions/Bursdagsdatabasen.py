#!/usr/bin/env python
# coding: utf-8

# In[ ]:


birthdays = {
"22 nov": ["Bob Bernt", "Mathias"],
"20 mar": "Simen",
"31 okt": ["Aragusta", "Carina"],
"12 jan": "Silje",
"3 sep": "Tobias",
"5 jul": ["Martin", "Øystein"],
"11 mar": "Miriam"
}
def add_birthday_to_date(date , name ):
    try :
        birthdays[date].append(name)
    except KeyError :
        birthdays[date] = name
    except AttributeError :
        birthdays[date] = [birthdays[date], name]
 
add_birthday_to_date("12 jan", "Sindre")
add_birthday_to_date("9 feb", "Lillian")
print(birthdays)

