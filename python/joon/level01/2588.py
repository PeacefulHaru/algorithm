row1 = input()
row2 = input()

sum = 0

for i in reversed(range(3)):
  first = int(row1)
  second = int(row2[i])
  multiple = first * second

  print(str(multiple))

  sum += 10 ** (2 - i) * multiple

print(sum)