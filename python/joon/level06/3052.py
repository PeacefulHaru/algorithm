import sys

A = [int(sys.stdin.readline()) % 42 for i in range(10)]
A.sort()

count = 1

for i in range(len(A) - 1):
  count += 1
  if A[i] == A[i + 1]: count -= 1

print(count)
  