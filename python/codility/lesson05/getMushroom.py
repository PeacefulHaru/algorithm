A = [2, 3, 7, 5, 1, 3, 9]

def prefix_sum(A):
    n = len(A)
    P = [0] * (n + 1) # Prefix Sum Result
    
    for pos in range(1, n + 1):
        # add previous & new value
        P[pos] = P[pos - 1] + A[pos - 1]
    
    P.pop(0) # Finally remove the first value
    return P; 

P = prefix_sum(A)    
print(P)
 
def sum_btwn(P, x, y):
    # Where y >= x
    if x > y: # when x is not supposed to be bigger
        temp_x = x
        x = y
        y = temp_x
    
    return P[y] - P[x - 1]
    
print(sum_btwn(P, 5, 1))


def harvest_mushroom(A, initial_pos, m):
    P = prefix_sum(A)
    n = len(A)
    result = 0
    
    # To the left first!
    max_move_left = min(initial_pos, m)
    for left_move in range(max_move_left + 1):
        x = initial_pos - left_move
        leftover_right_move = m - (left_move * 2) 
        y = min(initial_pos + leftover_right_move, n - 1)
        # if y is negative number
        if leftover_right_move < 0: y = initial_pos  
        
        # set y the initial position
        result = max(result, sum_btwn(P, x, y))
        print("move left first: " + str(x) + " | " + str(y) + "-> " + str(result))
        
    # To the right then!
    max_move_right = min(n - 1 - initial_pos, m)
    for right_move in range(max_move_right + 1):
        y = initial_pos + right_move # Move Right First
        
        leftover_left_move = m - (right_move * 2)
        x = max(initial_pos - leftover_left_move, 0)
        if leftover_left_move < 0: x = initial_pos 
        
        result = max(result, sum_btwn(P, x, y))
        print("move right first: " + str(x) + " | " + str(y) + "-> " + str(result))
        
        
    
    # Finally
    return result
    
result = harvest_mushroom(A, 4, 6)
print(result)