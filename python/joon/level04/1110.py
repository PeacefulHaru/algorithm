#

N = input()
orig = N
count = 1
flag = True

# handle when N = 0
if N == '0':
  flag = False

# first process
while orig != N or flag:
  if flag:
    flag = False
    count -= 1 # Only for the '0'
    
  count += 1

  # # Testing
  # if count > 15:
  #   break
  
  # Handle N >= 10
  if len(N) > 1:
    fir = N[1]
    sec = int(N[0]) + int(fir)
    fir = '' if fir == '0' else fir # handle i.e 01, 02 .. 09  
    if sec >= 10:
      sec = sec % 10
    
    # Testing
    # print(f"{fir} | {sec}", end=" ")

    N = fir + str(sec)
  
  # Handle N < 10
  else:
    N = N * 2

  # # Testing
  # print(N)

print(count)