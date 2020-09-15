# 2,724 ms, fastest version
# x version contains anything super fast, super efficient.

import sys 

N = int(input())
A = [sys.stdin.readline().split(" ") for i in range(N)]
# Above is the "FASTEST way to solve" 
# stdin.readline() = X Algorithm
# stdin.readline() includes \n as well, but you can just int() it and
# it will be good integer number.
# (Warning) readlines is a different function. NO 'S' this case.

for element in A:
  sum = int(element[0]) + int(element[1])
  print(sum)