N = int(input())

cross = 1
val = 2

while True:
  if N < val:
    break
  val += cross * 6
  cross += 1
  
print(cross)