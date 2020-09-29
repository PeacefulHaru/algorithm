N = int(input()) # 3 ~ 5000

count = 0 
while N > 0:
  # handle when it is divisible by 5
  if N % 5 == 0:
    count += N / 5
    break
  
  N -= 3
  count += 1

if N >= 0:
  print(int(count))
else:
  print(-1)
  

