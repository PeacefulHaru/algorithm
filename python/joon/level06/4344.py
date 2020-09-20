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

  # Work on printing the asked result
  above_average_std_count = 0
  for val in line:
    if val > average:
      above_average_std_count += 1

  # Print accordingly
  the_percent = round(above_average_std_count / num_of_students * 100, 3) # 40, 57.143  62.5
  
  # Pinrt decimal
  print(f"{int(the_percent)}.", end="")
  
  # Print Digit
  the_rest = int(round(int(the_percent % 1 * 10000), -1) / 10)
  print(f"{the_rest}", end="")

  # Print the rest
  zeros_required =  3 - len(str(the_rest))
  print('0' * zeros_required, end="")
  print('%')
  
  
