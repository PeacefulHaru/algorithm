/**
 *  We have a range of numbers starting at.."A" to "B"
 * 
 * k = integer
 * 
 * Begun on 10:51pm
 * */ 

 // evenly dividing, no left over

// Changable values
let a = 12;
let b = 12328514;

// i / k  => No remainder
let initial = 31231; //possible answer
let k = 35;

// if k

function solution(A, B, K) {
  // Since answer will be always 0 for k > i
  if(K > B) {
    return 0;
  }

  // Since answer will be always 1 for K = B
  if(K === B) {
    return 1;
  }

  // Since you don't have to loop around the small number under K
  let theStartingNumber = A > K ? A : K; // The initial 'i'
  let theIncrementingNumber = theStartingNumber;

  let theCount = 0; // Returning answer
  
  while(theIncrementingNumber < B) {
    // If the starting number was the same as B, then it would be already '1' in the top.

    if(theIncrementingNumber % K === 0){
      //if it is evenly divisible
      
      theCount++;
    }

    // Auto increment
    theIncrementingNumber++;
  } 

  return theCount;

}// end of 'solution' function

console.log(solution(a, b, k));