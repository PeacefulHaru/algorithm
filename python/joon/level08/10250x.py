#x
# When you re-use the variable, its type may change randomly (possbily the last one)
# Therefore never use the same variable

import sys

#T = int(input())
#arr = [sys.stdin.readline().strip('\n').split(" ") for i in range(T)]


def solution(A, B, C):
  floor = C % A if C % A != 0 else A
  num = int(C / A) + 1
  
  #Handle when the num is one digit
  if num < 10:
    print(f"{floor}0{num}")
  else:
    print(f"{floor}{num}")
    

# for i in range(T):
#   line = arr[i]
#   A, B, C = int(line[0]), int(line[1]), int(line[2])
#   solution(A, B, C)

for i in range(1, 10):
  solution(6, 12, i)