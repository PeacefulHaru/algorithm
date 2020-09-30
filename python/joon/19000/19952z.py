import sys

T = int(input())
for i in range(T):
  # Y2 is the place you would like to go
  H, W, O, F, X1, Y1, X2, Y2 = input().split(" ")
  H, W, O, F, X1, Y1, X2, Y2 = int(H), int(W), int(O), int(F), int(X1), int(Y1), int(X2), int(Y2)

  # Put obstacles in matrix
  A = [[0] * W] * H
  print(A[0][1])
  obstacles = [sys.stdin.readline() for j in range(O)]
  for line in obstacles:
    spot = line.split(" ")    
    A[int(spot[0]) - 1][int(spot[1]) - 1] = int(spot[2])
    print(A)
  
  # print(A)
  