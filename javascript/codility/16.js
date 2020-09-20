/**
 * Write a function

function solution(A);

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 * 
 */

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  if(A.length === 0) {
    return 0;
  }
  
  A.sort((a, b) => a - b)
  let count = 1; // includes the first value

  for(let i = 0 ; i < A.length - 1 ; i++) {
    if(A[i] !== A[i+1]){
      // count goes up only when they are different. 
      count++;
    }
  }

  return count;
}

 // Personal
 let A = [1, 2, 3, 5 , 5, 6, -1, 0, 5 ];
 console.log(solution(A));