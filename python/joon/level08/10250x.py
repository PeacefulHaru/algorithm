#x
# When you re-use the variable, its type may change randomly (possbily the last one)
# Therefore never use the same variable

import sys

T = int(input())
arr = [sys.stdin.readline().strip('\n').split(" ") for i in range(T)]

def solution(H, W, N): 
  # A = Height, B = Width C = N (The Nth Guest)
  # A, B, C All Integers
  floorInt = N % H if N % H != 0 else H
  numInt = int(N / H) + 1 if N % H != 0 else int(N / H)

  print(floorInt * 100 + numInt)

for i in range(T):
  line = arr[i]
  A, B, C = int(line[0]), int(line[1]), int(line[2])
  solution(A, B, C)

# for i in range(1, 10):
#   solution(6, 12, i)