import sys

A = [sys.stdin.readline().replace('\n', '') for i in range(5)]

sum = 0
for val in A:
   sum += int(val) if int(val) > 40 else 40

print(round(sum / 5))