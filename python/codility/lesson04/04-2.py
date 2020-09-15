# Fastest yet to come.  

# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(N, A):
# write your code in Python 3.6
    maxCount = N + 1 #
    dataArr = [0] * N
    highest = 0
    atLeastMax = 0

    for elem in A:
        if elem == maxCount:
            # Fill with the max
            atLeastMax = highest
            # dataArr = [highest] * N # This should consume a lot of time
        else:
            dataArr[elem - 1] = dataArr[elem - 1] + 1 if dataArr[elem - 1] >= atLeastMax else atLeastMax + 1
            highest = highest if highest >= dataArr[elem - 1] else highest + 1
    
        # print(dataArr)

    for idx, elem in enumerate(dataArr):
        if elem < atLeastMax:
            # if is not called, make it at least minimal required
            dataArr[idx] = atLeastMax


    return dataArr

# Execute
N = 5 
A = [3, 4, 4, 6, 1, 4, 4]
print(solution(N, A))