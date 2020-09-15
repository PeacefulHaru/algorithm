import sys

arr =[]

while True:
  lineArr = sys.stdin.readline().split(" ")
  A, B = int(lineArr[0]), int(lineArr[1])
  if A == 0 and B == 0:
    break
  else:
    arr.append(A + B)

for elem in arr:
  print(str(elem))