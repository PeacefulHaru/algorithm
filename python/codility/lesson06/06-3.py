#

def solution(A):
    # write your code in Python 3.6
    count = 0
    N = len(A)

    # handle when N = 0
    if N == 0:
        return -1

    for i, val in enumerate(A):
        followingValNums = N - i - 1 # f.. = 5
        count += followingValNums if followingValNums < val else val # val = 1

        howManyLeft = followingValNums - val if followingValNums - val > 0 else 0

        for j in range(howManyLeft):
            if A[i + j + 1 + val] >= j + 1:
                count += 1 

    return count if count > 0 else -1

        
        



# Execute
A = [1, 5, 2, 1, 4, 0]
print(solution(A))