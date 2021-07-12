# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def prefix_avg(A):
    # I think it is a better practice
    # If you do not remove the first value of 0
    n = len(A)
    P = [0] * (n + 1)
    for i in range(1, n + 1):
        previous_total = P[i - 1] * (i - 1)
        P[i] = (previous_total + A[i - 1]) / i
    
    return P

# O(1)
def get_avg(P, x, y):
    total_until_y = P[y + 1] * (y + 1)
    total_before_x = P[x] * x
    n = y - x + 1
    
    return (total_until_y - total_before_x) / n

def solution(A):
    P = prefix_avg(A)
    n = len(A)
    minimum = P[2] # at least A[0] ~ A[1]
    position = 0 

    # testing
    # print(position)

    # This causing O(N * N) -> Too slow
    for i in range(n - 1):
        for j in range(i + 1, n):
            if minimum > get_avg(P, i, j):
                minimum = get_avg(P, i, j)
                position = i

    return position
