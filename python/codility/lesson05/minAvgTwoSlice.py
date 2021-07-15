def prefix_sum(A):
    n = len(A)
    P = [0] * (n + 1)
    for i in range(1, n + 1):
        P[i] = P[i - 1] + A[i - 1]
        
    return P
    
def get_average(P, x, y):
    n = y - x + 1
    return (P[y + 1] - P[x]) / n
    

def solution(A):
    n = len(A)
    P = prefix_sum(A)
    
    lowest = P[2] / 2 # Assuming len(A) >= 2 with 0 included
    answer = 0
    
    for i in range(n - 1):
        # lenght 2
        if lowest > get_average(P, i, i + 1):
            lowest = get_average(P, i, i + 1)
            answer = i
            
        #Checker
        if i == n - 2: break
    
        # length 3
        if lowest > get_average(P, i, i + 2):
            lowest = get_average(P, i, i + 2)
            answer = i
    
    return answer
