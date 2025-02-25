# a)

antallCookies = int(input("Hvor mange cookies ønsker du å bake? "))
gramSukker = antallCookies/48 * 400
gramSmør = antallCookies/48 * 320
gramSjokolade = antallCookies/48 * 500
egg = antallCookies/48 * 2
hvetemel = antallCookies/48 * 460
 
print("Antall Cookies:", antallCookies, " \nsukker(g):", gramSukker,
      "\nsmør(g):", gramSmør, "\nsjokolade(g):", gramSjokolade, "\negg:", egg,
      "\nhvetemel(g):", hvetemel)


# b)


cookies1=int(input("Hvor mange cookies vil du lage? "))
cookies2=int(input("og hvor mange cookies vil du lage nå? "))
cookies3=int(input("og hvor mange cookies vil du lage til slutt? "))
 
sukker1=cookies1/48*400
sukker2=cookies2/48*400
sukker3=cookies3/48*400
sjokolade1=cookies1/48*500
sjokolade2=cookies2/48*500
sjokolade3=cookies3/48*500
 
print("Antall cookies: \tsukker(g) \tsjokolade(g)" )          
print(str(cookies1).ljust(17), str(sukker1).rjust(15), str(sjokolade1).rjust(17))
print(str(cookies2).ljust(17), str(sukker2).rjust(15), str(sjokolade2).rjust(17))
print(str(cookies3).ljust(17), str(sukker3).rjust(15), str(sjokolade3).rjust(17))

