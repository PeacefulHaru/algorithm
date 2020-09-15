import sys

arr = []
while True:
  line = sys.stdin.readline()
  if not line:
    break
  splitted = line.split(" ")
  arr.append(int(splitted[0]) + int(splitted[1]))

for element in arr:
  print(element)