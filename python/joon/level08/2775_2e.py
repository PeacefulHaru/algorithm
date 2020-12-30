# e: 70% less Length Code (Efficiency) 
# In terms of memory usage and speed, there was not so much difference

import sys
input = sys.stdin.readline

cases = int(input())
arr = [[room + 1 if floor == 0 or room == 0 else 0 for room in range(15)] for floor in range(15)]

for i in range(1, 15):
  for j in range(1, 15):
    arr[i][j] = arr[i - 1][j] + arr[i] [j - 1]

for _ in range(cases):
  k, n = int(input()), int(input())
  print(arr[k][n - 1])
