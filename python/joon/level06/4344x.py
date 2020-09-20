import sys

C = int(input())
A = [sys.stdin.readline().split(" ") for i in range(C)]

for line in A:
  # Declare neccesary
  num_of_students = int(line[0])
  line.pop(0)
  sum = 0

  # Calculate average (Meanwhile convert into integer)
  for i in range(num_of_students):
    target = line[i] = int(line[i])
    sum += target
  average = sum / num_of_students

  # Count above average students
  above_average_std_count = 0
  for val in line:
    if val > average:
      above_average_std_count += 1

  # Get the rate
  the_percent = round(above_average_std_count / num_of_students * 100, 3) # 40, 57.143  62.5
  
  #print
  print("{:.3f}%".format(round(the_percent, 3)))
  
  
