import sys

max, maxIndex = 0, 0

for i in range(9):
  line = int(sys.stdin.readline())
  if line > max: 
    max = line
    maxIndex = i + 1

print(max)
print(maxIndex)