givenInput = input()

arr = givenInput.split(" ")
A = int(arr[0])
B = int(arr[1])

if A > B:
  print(">")
elif A < B:
  print("<")
else:
  print("==")