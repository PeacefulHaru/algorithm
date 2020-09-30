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
  # Explain below: Why? adding elements is designed for the future adding. so it will kill one more.
  last_max_elements = max_elements - adding_elements + 1 
  last_steps = X - last_max_elements - 1 # first elemet does not change. so -1.

  # Dont touch this
  a -= last_steps
  b += last_steps

  # Finally
  print(f"{a}/{b}")

solution(X)