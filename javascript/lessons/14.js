/**
 * 
 * Write a function:

function solution(A, B, K);

that, given three integers A, B and K, returns the number of integers within the range [A..B] 
that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there 
are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorize
 */


function solution(A, B, K) {
  // write your code in JavaScript (Node.js 8.9.4)

  // if K > B, no evenly divisible
  if(K > B) return 0;

  let initialValueK = K;
  while(true){
    if(initialValueK >= A){
      // finally found
      return Math.floor((B - initialValueK + 1) / K); 
    }
    else{
      initialValueK += K;
    }
  }

  

}

// Personal 
let A = 0;
let B = 0;
let K = 11;

console.log(solution(A, B, K));