# More than a second, slower version

N = int(input())
A = [input().split(" ") for i in range(N)]
# Above is the "FASTEST way to solve"

for element in A:
  sum = int(element[0]) + int(element[1])
  print(sum)