#조합론, Math

import sys

numberOfTestCasesInt = int(input())

#Because this question weirdly gives you data without space, but instead with new line
numberOfRepeatsInt = numberOfTestCasesInt * 2

arr = [sys.stdin.readline().strip('\n') for i in range(numberOfRepeatsInt)]

print(arr)
