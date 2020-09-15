N = int(input())

for i in range(N):
  stars = "*" * (i + 1)
  blank = " " * (N - i - 1)
  print(blank + stars)