import sys

A = [int(sys.stdin.readline().replace('\n', '')) for i in range(5)]

sum = 0
sum += int(min(A[0: 3]))
sum += int(min(A[3:]))
sum -= 50

print(sum)