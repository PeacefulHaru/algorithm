# The concept
# at a certain position x. you can get how many cars going west 
# has passed and therefore you can subtract the total number of cars 
# going west from the cars already past
# The result will represent the future cars going west that
# the east car will pass, evnetually

def prefix_sum(A):
    n = len(A)
    P = [0] * (n + 1)
    for i in range(1, n + 1):
        P[i] = P[i - 1] + A[i - 1]
    
    P.pop(0)
    return P

def solution(A):
    P = prefix_sum(A)
    n = len(A)
    max_westing_cnt = P[n - 1]

    sum = 0 
    for i in range(n):
        if A[i] == 0: sum += max_westing_cnt - P[i]
        if sum > 1000000000: return -1 # By exception
    
    return sum


A = [0, 1, 0, 1, 0, 1, 0, 0, 1]
print(solution(A))