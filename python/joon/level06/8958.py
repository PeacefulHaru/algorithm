import sys

N = int(input())
A = [sys.stdin.readline().replace('\n', '') for i in range(N)]

for line in A:
  consecutive_score = 1
  score = 0

  for val in line:
    if val == 'O':
      score += consecutive_score
      consecutive_score += 1
    else:
      consecutive_score = 1

  print(score)  