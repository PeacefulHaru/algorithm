# RAM: 29380K (64ms) (0.064s)
X = int(input()) #3

def solution(X):
  max_elements = 1
  adding_elements = 2
  while True:
    # print(f"{max_elements} | {X}")
    if max_elements >= X: 
      # OK I can handle now. Stop this.
      break
    max_elements += adding_elements
    adding_elements += 1

  a = adding_elements - 1
  b = 1

  # print(f"{max_elements} | {adding_elements}")
  # Adding elements is the future, so you want to -1 for getting the current one
  num_of_this_row_elements = adding_elements - 1
  # Explain below: Why? adding elements is designed for the future adding. so it will kill one more.
  one_row_before_max_elements = max_elements - num_of_this_row_elements
  last_steps = X - one_row_before_max_elements - 1 # first elemet does not change. so -1.

  # Since this question forms zig-zag approach, you would like to either add or subtract last steps
  if num_of_this_row_elements % 2 == 0:
    # considred 'reversed'
    last_steps = num_of_this_row_elements - 1 - last_steps

  # Dont touch this
  a -= last_steps
  b += last_steps

  # Finally
  print(f"{a}/{b}")

solution(X)

# # checker
# for i in range (1, 20):
#   solution(i)