from fuzzywuzzy import process

#########################################################################
#https://www.datacamp.com/community/tutorials/fuzzy-string-python
########################################################################

str2Match = "apple inc"
strOptions = ["Apple Inc.","apple park","apple incorporated","iphone"]
Ratios = process.extract(str2Match,strOptions)
print("Ratios : {}".format(Ratios))
# You can also select the string with the highest matching percentage
highest = process.extractOne(str2Match,strOptions)
print("Highest : {}".format(highest))
