#

def solution(S, P, Q):
# write your code in Python 3.6
    
    stackArr = []
    arr = [0] * 4

    for char in S:
        if char == 'A': 
            arr[0] += 1
            stackArr.append(arr[:])
        elif char == 'C':
            arr[1] += 1
            stackArr.append(arr[:])
        elif char == 'G':
            arr[2] += 1
            stackArr.append(arr[:])
        else:
            arr[3] += 1
            stackArr.append(arr[:])

    result = []

    for i in range(len(P)):
        p, q = P[i], Q[i]
        calculation = []
        if p == 0:
            calculation = stackArr[q]
        else:
            for j in range(4):
                calculation.append(stackArr[q][j] - stackArr[p - 1][j])
        
        if calculation[0] >= 1:
            result.append(1)
        elif calculation[1] >= 1:
            result.append(2)
        elif calculation[2] >= 1:
            result.append(3)
        else:
            result.append(4)
    
    return result




# Execute
S = 'CAGCCTA'
P = [2, 5, 0]
Q = [4, 5, 6]
print(solution(S, P, Q))