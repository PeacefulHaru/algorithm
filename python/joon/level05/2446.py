N = int(input())

for i in reversed(range(N)):
  print(" " * (N - i - 1), end="")
  print("*" * (i * 2 + 1))

for i in range(N - 1):
  print(" " * (N - i - 2), end="")
  print("*" * ((i + 1) * 2 + 1))

