#
import math

def solution(A, B, K):
    # write your code in Python 3.6
    count = 0

    if A % K == 0:
        count += 1

    # A: 1~14  K = 2
    countA = math.floor(A / K)
    countB = math.floor(B / K)
    count += countB - countA
    
    
    return count


# Execute
A = 111
B = 222222222
K = 2
print(solution(A, B, K))