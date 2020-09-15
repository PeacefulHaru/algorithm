N = int(input())
arr = []

for i in range(N):
  given = input().split(" ")
  A = int(given[0])
  B = int(given[1])
  arr.append(A + B)
  
for i in range(N):
  print(arr.pop(0))
  