/**
 * 
 * 
 * 
 */

function solution(A, K) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length; // 3 <= N <= 100,000

  let minimalAmplitude = 0; // the answer
  let setupOnce = true; // used for the setup of minimal amplitude

  for(let i = 0; i < N - K + 1; i++){
    // For j loop
    let doOnlyOnce = true;
    let min = 0;
    let max = 0;

    for(let j = 0; j < N ; j++){ // confirmed
      if(i > j || j > i + K - 1){ // confirmed
        let theTarget = A[j];

        if(doOnlyOnce){
          doOnlyOnce = false;
          max = theTarget;
          min = theTarget;

        }else{
          max = theTarget > max ? theTarget : max;
          min = theTarget < min ? theTarget : min;
        }
      } // end of j for-loop 

    }
    if(setupOnce){
      setupOnce = false;
      minimalAmplitude = max - min;

    }else{
      theTemporaryAmpltitude = max - min;
      minimalAmplitude = minimalAmplitude < theTemporaryAmpltitude ? minimalAmplitude : theTemporaryAmpltitude; 
    
    }

  } // end of i for-loop 

  //if loop is over, return the result
  return minimalAmplitude;
}

// Personal
let A = [5, 3, 6, 1, 3];
let K = 2;
console.log("Answer: " + solution(A, K));