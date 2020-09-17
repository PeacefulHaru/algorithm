import sys

N = int(input())
A = sys.stdin.readline().split(" ")

max = 0
for i in range(N):
  if int(A[i]) > max: max = int(A[i])
  A[i] = int(A[i]) * 100
  
sum = 0
for i in range(N):
  A[i] /= max
  sum += A[i]

print(sum / N)