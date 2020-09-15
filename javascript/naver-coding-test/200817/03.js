/**
 * 
 * 
 * 
 */

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length; // 1 <= N <= 100,000 
  
  // handle when N = 1; (logically confirmed)
  if (N === 1) {
    return 1;
  }

  // handle when N = 2; (logically confirmed)
  if (N === 2){
    if(A[1] > A[0]) return 2;
    else return 1;
  }

  // Assume N >= 3 following: 
  let max = A[0];
  let min = 0; // Can assume in such with elements are all bigger than 0

  let dividing = 0;

  for(let i = 1; i < N; i++){
    // Starting from 1

    let target = A[i]; 
    if(target > max){
      min = max;
      max = target;
      dividing++;
    }else if(target < min){
      dividing--;
      min = target;
    }
  }

  // finally returning chunks 
  // Since if you slice once, it has two chunks, so add 1 up.
  // if dividing is 0, it still produces 1 chunk.
  return dividing + 1;
  
}

// Personal
let A = [4, 2, 1];
console.log(solution(A));