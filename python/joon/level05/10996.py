
N = int(input())
flag = True
for i in range(N):
  # first line
  howMany = int(N / 2) if N / 2 == int(N / 2) else int(N / 2) + 1
  print("* " * howMany) if N > 1 else print("*")

  # second line
  howMany = int(N / 2) if N / 2 == int(N / 2) else int(N / 2)
  if N > 1: print(" *" * howMany) 