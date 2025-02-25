#!/usr/bin/env python
# coding: utf-8

# a)

# In[ ]:


my_first_list = [1, 2, 3, 4, 5, 6]


# In[ ]:


#alternativt
my_first_list = [i for i in range(1,7)]


# b)

# In[ ]:


print(my_first_list[5])
#eller
print(my_first_list[-1])


# c)

# In[ ]:


my_first_list[4] = 'pluss'
#eller
my_first_list[-2] = 'pluss'


# d)

# In[ ]:


my_second_list = my_first_list[3:]


# e)

# In[ ]:


print (my_second_list, 'er lik 10')

