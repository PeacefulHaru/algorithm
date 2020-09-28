S = input()

special_characters = ['c','d','l','n','s','z']
actual_characters = ['c=','c-','d-' ,'lj','nj','s=','z='] #dz= is special one
length = len(S) # 5
skip_count = 0
count = 0

for i, val in enumerate(S):
  if skip_count > 0:
    skip_count -= 1
  else:
    count += 1
    if i + 2 < length and val+ S[i + 1] + S[i + 2] == 'dz=': # only for dz=
        skip_count += 2
    elif i + 1 < length and val + S[i + 1] in actual_characters:
      skip_count += 1
      

print(count)