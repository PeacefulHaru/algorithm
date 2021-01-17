#n: not my code

import math
from sys import stdin

def input():
    return list(map(int, stdin.readline().split(' ')))


def s(n):
    k = int(math.ceil(math.sqrt(n)))
    n1 = k * k
    n0 = n1 - k
    m = 2 * k - 1
    return m if n > n0 else m - 1


for i in range(input()[0]):
    a, b = input()
    print(s(b - a))