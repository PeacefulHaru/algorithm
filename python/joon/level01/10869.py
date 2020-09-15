import math

givenInput = input()
arr = givenInput.split(" ")

A = int(arr[0])
B = int(arr[1])

print(A + B)
print(A - B)
print(A * B)
print(math.floor(A / B))
print(A % B)