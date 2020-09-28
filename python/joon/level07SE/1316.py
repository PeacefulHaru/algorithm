import sys

N = int(input())
A = [sys.stdin.readline().replace('\n', '') for i in range(N)]
count = 0

for line in A:
  checker = [False] * 26
  last_character = ''
  found = False

  for char in line: # i.e aabba
    idx = ord(char) - 97 #ordial, 차례를 의미함 # a~z: 97~132

    if checker[idx] and last_character != char: 
      # it is a problem
      found = True
      break

    else: 
      # Get a new character
      checker[idx] = True
      last_character = char

  if not found:
    count += 1
    
print(count)

# 0 is not natural number. natural number has to be positive number
# positive number == natural number