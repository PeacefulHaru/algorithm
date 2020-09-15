import sys

N = int(input())
A = [sys.stdin.readline().split(" ") for i in range(N)]

index = 1
for element in A:
  sum = int(element[0]) + int(element[1])
  print(f"Case #{index}: {sum}")
  index += 1