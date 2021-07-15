# Looks like O(N + M)

def prefix_avg(A):
    n = len(A)
    P = [0] * (n + 1)
    for i in range(1, n + 1):
        previous_total = P[i - 1] * (i - 1)
        P[i] = (previous_total + A[i - 1]) / i
        
    P.pop(0)
    return P
    # removeFrontParticleAndGetLowest
def getLowestWithP(P):
    #Requires P with at least the length of 2
    removingValue = P[0] # The first number, not average
    P.pop(0)
    lowest = min(P)
    
    for idx, val in enumerate(P):
        P[idx] = (val * (idx + 2) - removingValue) / (idx + 1)
    # [1, 2, 5, 4, 7]
    
    return lowest, P

def solution(A):
    P = prefix_avg(A)
    n = len(A)
    lowest = P[1] # at least A[0] ~ A[1] 
    position = 0 
    
    # Better soltuion only solving with P value with O(N)
    for starting_here in range(n - 1):
        newLowest, P = getLowestWithP(P)
        if lowest > newLowest:
            lowest = newLowest
            position = starting_here
    
    return position
    
    
A = [4, 2, 2, 5, 1, 5, 8]
print(solution(A))
