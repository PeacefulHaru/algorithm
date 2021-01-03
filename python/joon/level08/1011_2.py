import sys
input = sys.stdin.readline

def solution(x, y):
  x, y = 0, y - x
  count = 0
  length = y
  xSpeed, ySpeed = 1, 1
  
  while True:
    length -= xSpeed
    count += 1
    if length <= 0:
      break

    length -= ySpeed
    count += 1

    if length <= 0:
      break

    xSpeed += 1
    ySpeed += 1
  
  print(count)

T = int(input())

for _ in range(T):
  arr = input().split(" ")
  solution(int(arr[0]), int(arr[1]))