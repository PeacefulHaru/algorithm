import sys

N = int(input())
A = sys.stdin.readline().split(" ")

min, max = int(A[0]), int(A[0])

for val in A:
  if max < int(val): max = int(val)
  elif min > int(val): min = int(val)

print(f"{min} {max}")