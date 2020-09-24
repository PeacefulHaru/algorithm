S = input()

A = [-1] * 26

for i, val in enumerate(S):
  position = ord(val) - 97 # a = 97 ASCII
  if A[position] == -1:
    A[position] = i

# Print
for val in A:
  print(val, end=" ")
print()