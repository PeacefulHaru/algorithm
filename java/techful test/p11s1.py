# The S Tag at the end of the file defines following:
#   1) It has been used for the experiment, supportive file. 

# Python3 program to replace all of the O's in the matrix 
# with their shortest distance from a guard 
from collections import deque as queue 
  
# store dimensions of the matrix 
M = 5
N = 5
  
  
# These arrays are used to get row and column 
# numbers of 4 neighbors of a given cell 
row = [-1, 0, 1, 0] 
col = [0, 1, 0, -1] 
  
# return true if row number and column number 
# is in range 
def isValid(i, j): 
    if ((i < 0 or i > M - 1) or (j < 0 or j > N - 1)): 
        return False
  
    return True
  
# return true if current cell is an open area and its 
# distance from guard is not calculated yet 
def isSafe(i, j,matrix, output): 
  
    if (matrix[i][j] != 'O' or output[i][j] != -1): 
        return False
  
    return True
  
# Function to replace all of the O's in the matrix 
# with their shortest distance from a guard 
def findDistance(matrix): 
    output = [[ -1 for i in range(N)]for i in range(M)] 
    q = queue() 
  
    # finding Guards location and adding into queue 
    for i in range(M): 
        for j in range(N): 
              
            # initialize each cell as -1 
            output[i][j] = -1
            if (matrix[i][j] == 'G'): 
                pos = [i, j, 0] 
                q.appendleft(pos) 
                  
                # guard has 0 distance 
                output[i][j] = 0
  
  
    step = 0
    # do till queue is empty 
    while (len(q) > 0):
        step += 1
        print("#" + str(step))
        for i in range(M):
            for j in range(N):
                if matrix[i][j] == 'W':
                        print("W", end="  ")
                elif output[i][j] >= 0:
                    print(output[i][j], end="  ")
                else:
                    print(output[i][j],end=" ")
            print()

        print()    

        # get the front cell in the queue and update 
        # its adjacent cells 
        curr = q.pop() 
        x, y, dist = curr[0], curr[1], curr[2] 
  
        # do for each adjacent cell 
        for i in range(4): 
              
            # if adjacent cell is valid, has path and 
            # not visited yet, en-queue it. 
  
            if isValid(x + row[i], y + col[i]) and isSafe(x + row[i], y + col[i], matrix, output) : 
                output[x + row[i]][y + col[i]] = dist + 1
  
                pos = [x + row[i], y + col[i], dist + 1] 
                q.appendleft(pos) 
  
    # proutput matrix 
  
    for i in range(M): 
        for j in range(N): 
            if output[i][j] > 0: 
                print(output[i][j], end="  ") 
            else: 
                print(output[i][j],end=" ") 
        print() 
  
  
# Driver code 
  
matrix = [
    ['O', 'O', 'O', 'O', 'G'], 
    ['O', 'W', 'W', 'O', 'O'], 
    ['O', 'O', 'O', 'W', 'O'], 
    ['G', 'W', 'W', 'W', 'O'], 
    ['O', 'O', 'O', 'O', 'G']
  ] 
  
findDistance(matrix) 
  
# This code is contributed by mohit kumar 29 