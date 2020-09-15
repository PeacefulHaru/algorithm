/**
 * 
 * 
 * 
 */
function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length; // 1 <= N <= 200,000

  // Handle when N === 1 (It requires at least two)
  if(N === 1) {
    return -1;
  }

  // Sort in descending order
  A.sort((a, b) => b - a); 

  // For faster performance, save the last sum of digits
  let isLastDataAvailable = false;
  let lastData = 0;

  // We can now assume N >= following.
  for(let i = 0; i < N - 1; i++){
    // Run only once, then use the last data for faster speed

    let firstNumSum = 0; // the comparing target

    if(isLastDataAvailable){
      firstNumSum = lastData; // insert the last data into the first sum
                              // Without calculating
    }else{
      // Handle the first number
      let firstNum = A[i];
      let firstNumArr = firstNum.toString().split('');
      firstNumArr.forEach(digitStr => {
        firstNumSum += parseInt(digitStr);
      })
    }

    // Handle the second number
    let secondNum = A[i + 1];
    let secondNumArr = secondNum.toString().split('');
    let secondNumSum = 0; // the comparing target
    secondNumArr.forEach(digitStr => {
      secondNumSum += parseInt(digitStr);
    })

    // Set up the last data history
    if(!isLastDataAvailable) isLastDataAvailable = true;
    lastData = secondNumSum;

    if(firstNumSum === secondNumSum){
      // it means it has found the digits adding up to an equal sum
      return A[i] + A[i + 1];
    }
  }

  // If it fails to return the sum, it means it has failed to find
  // the digits add up to an equal sum
  return -1;
}

// Personal
let A = [42, 33, 60];
console.log(solution(A));