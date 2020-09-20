/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) 
 * is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if 
there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range
 [−2,147,483,648..2,147,483,647].
 * 
 */

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length;
  if(N < 3) {
    // it requires at least three elements for the triplet
    return 0;
  }

  // You can now assume N is bigger or equal to 3
  // N >= 3

  A.sort((a, b) => a - b);

  for(let i = 0; i < N -2 ; i++){
    let sum = A[i] + A[i+1];
    if(sum > A[i+2]){
      //Found 
      return 1;
    }
  }

  // if it fails the test, it means it has not found anything
  return 0;
}

// Personal
let A = [0,0,0,0,1,1,1];
console.log(solution(A));