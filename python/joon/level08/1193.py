# X = int(input())

def solution(X):
  row = 1
  a = 1
  b = 1
  count = 1

  # handle 1 exception
  if X == 1:
    print('1/1')
    exit()

  while True:
    row += 1
    isEvenRow = row % 2 == 0
    if isEvenRow: a += 1
    else: b += 1
    count += 1

    for i in range(row - 1):
      if X == count:
        break

      a -= 1 if isEvenRow else -1
      b += 1 if isEvenRow else -1
      count += 1
    
    if X == count:
      break

  print(str(a) + '/' + str(b))

for i in range(2, 20):
  print(f"{i}: ", end="")
  solution(i)