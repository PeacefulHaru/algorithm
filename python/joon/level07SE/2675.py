import sys

T = int(input())
A = [sys.stdin.readline().rstrip().split(" ") for i in range(T)]

for i in range(T):
  repeat = int(A[i][0])
  data = A[i][1]
  for val in data:
    print(val * repeat, end="")
  print()