import sys

f_line = input().split(" ")
N = int(f_line[0])
X = int(f_line[1])
A = sys.stdin.readline().split(" ")

for elem in A:
  if int(elem) < X:
    print(elem, end = " ")