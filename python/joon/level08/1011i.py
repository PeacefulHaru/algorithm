# i: inefficient

import sys
input = sys.stdin.readline

def sequenceFormula(n):
  return n * (n + 1) / 2

maxRange = 46340
maxArr = [0] * maxRange
for i in range(1, maxRange):
  maxArr[i] = int(sequenceFormula(i))

def speedDecider(leftOverPosition, currentSpeed):
  max = 0
  for i in range(maxRange):
    if maxArr[i] > leftOverPosition:
      max = i - 1
      break
  if currentSpeed < max:
    return currentSpeed + 1
  elif currentSpeed == max:
    return currentSpeed
  else:
    return currentSpeed - 1

def sol(x, y):
  shortestCount = 0
  speed = 0
  x, y = 0, y - x
  while x < y:
    speed = speedDecider(y - x, speed) #decides the speed
    x += speed #moves
    shortestCount += 1
  
  print(shortestCount)


T = int(input())

for _ in range(T):
  arr = input().split(" ")
  sol(int(arr[0]), int(arr[1]))