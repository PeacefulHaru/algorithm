


def solution(A):
    # write your code in Python 3.6
    maxVal = -1
    max = -1
    maxPos = -1
    orig = list(A)
    A.sort()
    N = len(A)
    
    count = 1

    for i in range(0, N - 1):
        
        if A[i] == A[i + 1]:
            count += 1
        else:
            if count > max:
                max = count
                maxVal = A[i]
                maxPos = i
            
            count = 1
    # print(f"{max} | {maxVal}")
    # result = []
    # for i in range(N):
    #     if orig[i] == maxVal:
    #         result.append(i)


    
    if max < N / 2:
        return -1
    else:
        return maxPos
    
    



# Execute
A = [3, 4, 3, 2, 3, -1 ,3, 3]
print(solution(A))