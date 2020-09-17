#

A = int(input())
B = int(input())
C = int(input())

multi = A * B * C

A = [0] * 10

for val in str(multi):
  A[int(val)] += 1

for val in A:
  print(val)