import math

arr = input().split(" ")
A, B, V = int(arr[0]), int(arr[1]), int(arr[2])

# Because of the fact that snail can go up ealier. I will name it as last handling power
last_handling_power = B 
# If you substract the amount of power to the distance, I can simply calculate it 
distance = V - last_handling_power
# if it is 33.444 that means it requires 33 days + 1 more extra, so you ceil it
days = math.ceil(distance / (A - B))

print(days)