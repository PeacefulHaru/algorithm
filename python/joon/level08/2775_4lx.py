#x: Import only one function from math!
#l: Less than expected, thought it would use less memory usage, but 6% more instead.
from math import comb
import sys

input = sys.stdin.readline

cases = int(input())

def convertIntoCombinationThenCalcualte(floor, room):
  # These
  n = floor + room 
  k = floor + 1
  print(comb(n, k))

for _ in range(cases):
  floor, room = int(input()), int(input())
  convertIntoCombinationThenCalcualte(floor, room)
  

