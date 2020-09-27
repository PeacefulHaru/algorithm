import math

S = input()

def convert_to_number (letter): #logically confirmed
    # A -> 65
    # A ~ C 65~67
    if letter == 'Z':
        return 9
    exception = 0 # Due to 7 has 4 letters 
    if ord(letter) >= 83: # 83 == S
        exception = 1
    return math.floor((ord(letter) - 65 - exception) / 3) + 2

answer_seconds = 0
for val in S:
    answer_seconds += convert_to_number(val) + 1

print(answer_seconds)