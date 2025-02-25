#!/usr/bin/env python
# coding: utf-8

# In[ ]:


import math
 
def f(x):
    return (x-12)*math.exp(0.5*x) - 8*(x+2)**2
 
def g(x):
    return -x -2*x**2 - 5*x**3 + 6*x**4
 
def differentiate(x_k, x_k1, func):
    return (func(x_k) - func(x_k1))/(x_k - x_k1)
 
def secant_method(x_0,x_1,func,tol):
    diff = abs(x_1 -x_0)
    while diff > tol:
        x_2 = x_1 - func(x_1)/differentiate(x_1,x_0,func)
        diff = abs(x_2 - x_1)
        x_0 = x_1
        x_1 = x_2
    return x_2
 
def main():
    print(f(0))
    print(g(1))
    print(differentiate(9,10,f))
    x = secant_method(11,13,f,0.00001)
    print(x)
    print(f(x))
    x = secant_method(1,2,g,0.00001)
    print(x)
    print(g(x))
    x = secant_method(0,1,g,0.00001)
    print(x)
    print(g(x))
 
main()

