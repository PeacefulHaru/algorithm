
function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  A = A
    .sort((a, b) => a - b)
    .filter(element => element > 0);

  // testing 
  // console.log(A);

  // if empty, it means all the numbers were negative or 0
  if(A.length === 0){
    return 1;
  }

  // if it is not one already, just return 1
  if(A[0] !== 1) {
    return 1;
  }

  let standard = 1;
  
  for(let i = 0 ; i < A.length ; i++) {
    let examTarget = A[i];

    if(examTarget === standard){
      // everything's good, move on.
    }else if(examTarget === standard + 1){
      // oh, the next number.
      standard++;
    }else{
      // oh no, there is an answer.
      return standard + 1;
    }
  }

  // if everything is passed, the max number does not exist there.
  return standard + 1;
}

// Personal
let A = [-1, 0, 1, 2, 3, 5, 6];
console.log(solution(A));