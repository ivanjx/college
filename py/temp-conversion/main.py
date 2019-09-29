# Input celcius.
input_str = input('Suhu celcius: ')
celcius = float(input_str)

# Konversi ke kelvin.
kelvin = celcius + 273
        
# Konversi ke Reamur.
reamur = celcius * 4 / 5

# Konversi ke Fahrenheit.
fahrenheit = celcius * 9 / 5 + 32

# Print hasil.
print("Kelvin: " + str(kelvin))
print("Reamur: " + str(reamur))
print("Fahrenheit: " + str(fahrenheit))