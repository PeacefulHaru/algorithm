import sys

input()
second_line = sys.stdin.readline().replace('\n', '')

sum = 0
for val in second_line:
  sum += int(val)


print(sum)
