import Levenshtein as lev

#########################################################################
#https://www.datacamp.com/community/tutorials/fuzzy-string-python
########################################################################

Str1 = "Ivan Juan Kara"
Str2 = "ivan j. k."
Distance = lev.distance(Str1.lower(), Str2.lower()),
print(Distance)
Ratio = lev.ratio(Str1.lower(), Str2.lower())
print(Ratio)
