/**
 * 
 * An array A consisting of N different integers is given. The array contains 
 * integers 
 * in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

function solution(A);

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Copyright 2009–2020 by Codility Limited. All Rights Reserved.
 Unauthorized copying, publication or disclosure prohibited.
 */

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)
  let N = A.length - 1;
  
  // handle N = 0;
  if(A.length === 0) return 1;


  // handle the rest N > 1;
  A.sort((a, b) => a - b);

  // testing
  // console.log(A);

  for(let i = 0; i < A.length ; i++) {
    if(A[i] !== i + 1) {
      return i + 1;
    }
  }

  // if not retured, the biggest number is the missing one.
  return A[A.length - 1] + 1;
}

// Personal
let A = [2];
console.log(solution(A));