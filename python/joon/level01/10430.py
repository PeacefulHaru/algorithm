givenInput = input()
arr = givenInput.split(" ")

A = int(arr[0])
B = int(arr[1])
C = int(arr[2])

print(str((A + B) % C))
print(str(((A % C) + ( B % C)) % C))
print(str((A * B) % C))
print(str(((A % C) * (B % C)) % C))