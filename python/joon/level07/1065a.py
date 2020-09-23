# a defines a new algorithm system

#한수??
#Brute Force Search (Algorithm) (Exhaustive Search)(Generate and Test)
# Examplse
# Linear Search (Check everything)
# Eight queens puzzle
# 100% Correction Rate

N = int(input())

# Hadle when its less than 100
if N < 100: 
  print(N)
  exit()

count = 99
for i in range (100, N + 1):
  target_str = str(i)
  diff = int(target_str[1]) - int(target_str[0])
  if int(target_str[1]) + diff == int(target_str[2]):
    count += 1

print(count)