from fuzzywuzzy import fuzz

#########################################################################
#https://www.datacamp.com/community/tutorials/fuzzy-string-python
########################################################################

print("matching : Apple Inc. VS apple Inc")
Str1 = "Apple Inc."
Str2 = "apple Inc"
Ratio = fuzz.ratio(Str1.lower(),Str2.lower())
print("Ratio : {}".format(Ratio))
print()

print("matching : Los Angeles Lakers VS Lakers")
Str1 = "Los Angeles Lakers"
Str2 = "Lakers"
Ratio = fuzz.ratio(Str1.lower(),Str2.lower())
Partial_Ratio = fuzz.partial_ratio(Str1.lower(),Str2.lower())
print("Ratio : {}".format(Ratio))
print("Partial Ratio : {}".format(Partial_Ratio))
print()

print("matching : united states v. nixon VS Nixon v. United States")
Str1 = "united states v. nixon"
Str2 = "Nixon v. United States"
Ratio = fuzz.ratio(Str1.lower(),Str2.lower())
Partial_Ratio = fuzz.partial_ratio(Str1.lower(),Str2.lower())
Token_Sort_Ratio = fuzz.token_sort_ratio(Str1,Str2)
print("Ratio : {}".format(Ratio))
print("Partial Ratio : {}".format(Partial_Ratio))
print("Token Sort Ratio : {}".format(Token_Sort_Ratio))
print()

print("matching : Ivan Kara VS ivan juan kara")
Str1 = "Ivan Kara"
Str2 = "ivan juan kara"
Ratio = fuzz.ratio(Str1.lower(),Str2.lower())
Partial_Ratio = fuzz.partial_ratio(Str1.lower(),Str2.lower())
Token_Sort_Ratio = fuzz.token_sort_ratio(Str1,Str2)
print("Ratio : {}".format(Ratio))
print("Partial Ratio : {}".format(Partial_Ratio))
print("Token Sort Ratio : {}".format(Token_Sort_Ratio))
print()
