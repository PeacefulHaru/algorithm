A = [False] * 10000 # 0 ~ 9999

LIMIT = 10000

def d(n: int):
  # Calculte the next
  sum = n
  for val in str(n):
    sum += int(val)
  
  # Do next
  if sum >= LIMIT:
    return
  else:
    if A[sum] == True:
      # Already have been calculated
      return
    else:
      A[sum] = True
      d(sum)
    

# Calculate for each number
for val in range (1, LIMIT):
  if A[val] == False:
    # Not calculated.
    d(val)

# Print
for i in range(1, LIMIT):
  if A[i] == False:
    print(i)




