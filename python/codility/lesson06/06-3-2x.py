# sub_li.sort(key = lambda x: x[1])

def solution(A):
    # write your code in Python 3.6
    B = []
    cnt = 0

    for i, val in enumerate(A):
        B.append([i - val, i + val])

    B.sort(key = lambda x: x[0])
    # print(B)

    for i, val in enumerate(B):
        untilAt = val[1]
        for j in range(len(B)):
            checkIdx = i + j + 1
            if checkIdx == len(B):
                break

            if B[checkIdx][0] <= untilAt:
                cnt += 1
                if cnt > 10000000:
                    return -1
                    
            else:
                # Because they are sorted.
                break
    
    return cnt
        


# Execute
A = [1, 5, 2, 1, 4, 0]
print(solution(A))