S = input().strip()

count = 0
is_last_space = True
for val in S: 
  if val == ' ':
    # at space ocean
    is_last_space = True
    
  elif val != ' ' and is_last_space:
    # new string foudn
    count += 1
    is_last_space = False

print(count)
  
