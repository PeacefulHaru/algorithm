A, B = input().split(" ")

def read_weird (numStr):
    result = ""
    for i in reversed(range(3)):
        result += numStr[i]
    return result

A = read_weird(A)
B = read_weird(B)

if int(A) > int(B):
    print(A)
else:
    print(B)