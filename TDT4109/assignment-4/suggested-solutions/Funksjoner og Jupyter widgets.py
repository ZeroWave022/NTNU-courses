#!/usr/bin/env python
# coding: utf-8

# In[6]:


#a)
from ipywidgets import interact, interactive, fixed, interact_manual
from IPython.display import display
import ipywidgets as widgets

def f(x):
    return x**2+10

interact(f,x=widgets.FloatSlider(min=-15,max=20,step=0.2,value=3))


# In[8]:


#b
from ipywidgets import interact, interactive, fixed, interact_manual
from IPython.display import display
import ipywidgets as widgets

def equation(a,b,c,x,reverse,statement):
    if reverse:
        new_statement = ""
        for char in statement:
            if char.isupper():
                new_statement+=char.lower()
            else:
                new_statement+=char.upper()
        statement = new_statement
        a = -a
    return statement, a*x**2+b*x+c

interact(equation,a=1,b=1,c=1,x=1,reverse=True,statement="hei")    


# In[10]:


#c
from ipywidgets import interact, interactive, fixed, interact_manual
from IPython.display import display
import ipywidgets as widgets

tekst = widgets.Textarea(
    value='Hello World',
    placeholder='Type something',
    description='tekst:',
    disabled=False
)
display(tekst)

def hello(b):
    print(tekst.value)
    
button = widgets.Button(
    description='Click me',
    disabled=False,
    tooltip='Click me',
)
    
button.on_click(hello)
display(button)


# In[13]:


#d
from ipywidgets import interact, interactive, fixed, interact_manual
from IPython.display import display
import ipywidgets as widgets

def generate_mc(question,answers,answer):
    alternativ = widgets.RadioButtons(
    options=answers,
    description='',
    disabled=False)
    print(question)
    button = widgets.Button(description="Sjekk svaret")
    display(alternativ)
    display(button)
    
    def check_answer(b):
        a = alternativ.value
        if(a==answer):
            print("riktig")
        else:
            print("feil")
            
    button.on_click(check_answer)
            
generate_mc("Hvilken pizza er best?",["Pepperoni","Ost og skinke","Ananas og pepperoni"],"Pepperoni")

