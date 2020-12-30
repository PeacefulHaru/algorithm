#x How to Create an double dimensional array with 0s filled

#조합론, Math

import sys

numberOfTestCasesInt = int(input())

#Because this question weirdly gives you data without space, but instead with new line
numberOfRepeatsInt = numberOfTestCasesInt * 2

arr = [sys.stdin.readline().strip('\n') for i in range(numberOfRepeatsInt)]

def solution(buildingHeightInt, buildingWidthInt):
	arr = [[0] * buildingWidthInt] * buildingHeightInt

	for floor in range(buildingHeightInt):
		for room in range(buildingWidthInt):
			# Any first room in the floor has only 1 person.
			if room == 0:
				arr[floor][room] = 1
			elif floor == 0: # floor starts from 0
				arr[floor][room] = room + 1 # room = 0 is room number 1 in real life
			else:
				arr[floor][room] = arr[floor][room - 1] + arr[floor - 1][room]
	
	# Return the last value of the array
	return arr[buildingHeightInt - 1][buildingWidthInt - 1]
			
			
count = 0
while count < numberOfRepeatsInt:
	floorStartingFromZero = int(arr[count])
	roomStartingFromOne = int(arr[count + 1])
	
	result = solution(floorStartingFromZero + 1, roomStartingFromOne)
	print(result)
	count = count + 2