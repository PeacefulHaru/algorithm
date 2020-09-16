N = int(input())

for i in range(N):
  print("*" * (i + 1))

for i in reversed(range(N - 1)):
  print("*" * (i + 1))