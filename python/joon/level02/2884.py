givenInput = input()

arr = givenInput.split(" ")

hour = int(arr[0])
min = int(arr[1])

leftMin = min - 45 # 55 - 45 = 10

# handles when it is negative
if leftMin < 0:
  hour -= 1
  leftMin += 60
  if hour == -1:
    hour = 23

print(str(hour) + " " + str(leftMin))