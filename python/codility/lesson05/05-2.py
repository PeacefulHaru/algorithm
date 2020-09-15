#

def solution(S, P, Q):
    # write your code in Python 3.6
    result = []
    
    switchType = {
        'C': 0,
        'G': 1,
        'T': 2
    }
    
    for i in range(len(P)):
        a, b = P[i], Q[i]
        # print(f"{result}")
        switch = [False] * 3
        flag = True

        for j in range(b - a + 1):
            if S[a + j] == 'A':
                result.append(1)
                flag = False
                break
            else:   
                switch[switchType[S[a + j]]] = True # S[j] = C, G or T
        
        if flag:
            for idx, val in enumerate(switch):
                if val:
                    result.append(idx + 2)
                    break
    
    return result




# Execute
S = 'CAGCCTA'
P = [2, 5, 0]
Q = [4, 5, 6]
print(solution(S, P, Q))