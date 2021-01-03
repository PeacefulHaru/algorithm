import sys
input = sys.stdin.readline

cases = int(input())

def solution(k, n):
  acceleration = 0
  increasing = k + 1
  count = 1
  value = 1
  while(count < n):
    value += increasing
    acceleration += 1
    increasing = increasing + acceleration
    count += 1
  print(value)

for _ in range(cases):
  k, n = int(input()), int(input())
  solution(k, n)