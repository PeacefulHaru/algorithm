S = input().upper()
A = [0] * 26

ascii_val_of_A = ord('A') # If you forgot the ASCII value (65 == A actually)

# 
for val in S:
  position = ord(val) - ascii_val_of_A # 0 ~ 25
  A[position] += 1

# Calculate 
max = 0
max_A_index = 0
isDuplicate = False
for i, val in enumerate(A):
  if val > max:
    # new max
    max = val
    max_A_index = i
    isDuplicate = False
  elif val == max:
    # duplicate
    isDuplicate = True

# Print
if not isDuplicate:
  print(chr(max_A_index + ascii_val_of_A))
else:
  print('?')

