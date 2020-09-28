import math

A, B, C = input().split(" ")
A, B, C = int(A), int(B), int(C)

if B >= C:
  # if making price is more expensive or the smae as C
  print(-1)
  exit()

result = 0

how_many = A / (C - B)
if (how_many % 1) == 0:
  result = how_many + 1
else:
  result = math.ceil(how_many)

print(int(result))