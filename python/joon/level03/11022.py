import sys

T = int(input())
A = [sys.stdin.readline().split(" ") for i in range(T)]

index = 1
for element in A:
  sum = int(element[0]) + int(element[1])
  print(f"Case #{index}: {element[0]} + {int(element[1])} = {sum}")
  index += 1