# e: Shortest length so far
# m: Pascal's Triangle
# n: Not My Code
# x: // integer division (just like comment in JS)

# Still have not understood how this worㅂks (12/30/20 11:43am)

import sys
I = sys.stdin.readline
O = sys.stdout.write

def N(k, n):
    num = den = 1
    for x in range(n - 1):
        num *= x + k + 2
        den *= x + 1
        print("num " + str(num))
        print("den " + str(den))    
    
    print("num // den " + str(num // den))
    return num // den

T = int(I())
for _ in range(T):
    k = int(I()); n = int(I())
    O(str(N(k, n)) +'\n')