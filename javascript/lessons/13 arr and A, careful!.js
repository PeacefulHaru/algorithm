// A.length can be 1 ~ 100,000  (N integers) (happens only once)
// A's values can be 1 ~ 1B (positive integer)
// if not permutation, return 0
// if permutation, return 1

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)
  let N = A.length;

  let arr = new Array(N).fill(false);

  for(let i = 0 ; i < N ; i++){
    let element = A[i];

    if(element > N){
      // if element is bigger, auto 
      return 0;
    }
  
    if(arr[element - 1]){
      //if it is already true
      return 0;
    }else{
      arr[element - 1] = true;
    }
  }

  // if it passes the exam, it means it has passed everything
  return 1;
  
}

let A = [4, 1 ,3]; 
console.log(solution(A));