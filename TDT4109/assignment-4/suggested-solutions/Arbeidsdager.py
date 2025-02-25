#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


def is_leap_year(year):
    if year % 400 == 0:
        return True
    elif year % 100 == 0:
        return False
    elif year % 4 == 0:
        return True
    return False
  
def weekday_newyear(year):
    weekday = 0 # Mandag
    for i in range(1900, year):
        days_in_year = is_leap_year(i) and 366 or 365
        weekday = (weekday + days_in_year) % 7
    return weekday
 
ukedager = [" man", "tir", "ons", "tor", "fre", "lør", "søn "]
 
for i in range(1900 ,1920):
    print(i, ukedager[weekday_newyear(i)])
     
    #Kodesnutten under er en annen måte å løse utskriftsoppgaven på
    #print(i, [" man", "tir", "ons", "tor", "fre", "lør", "søn "][weekday_newyear(i)])


# b)

# In[ ]:


def is_workday ( weekday ):
    return 0 <= weekday < 5


# c)

# In[ ]:


def workdays_in_year ( year ):
    weekday = weekday_newyear ( year )
    days_in_year = is_leap_year ( year ) and 366 or 365
    workdays = 0
    for i in range ( days_in_year ):
        if is_workday ( weekday ):
            workdays += 1
        weekday = ( weekday + 1) % 7
    return workdays
     
for i in range (1900 , 1920 ):
    print (i, " har", workdays_in_year (i), " arbeidsdager ")

