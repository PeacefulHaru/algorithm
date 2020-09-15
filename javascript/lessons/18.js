
function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length; // N: 0 <= N < N
  
  if(N === 0 || N === 1){
    // If the length is empty or just one
    return 0;
  }

  let count = 0;

  // Now it must be N >= 2 from here.
  for(let i = 0; i < N - 1 ; i++){
    // Do not need to check the last one, therefore N - 1

    let radiusGiven = A[i];
    let numOfElementsBehind = N - i - 1;
    count += radiusGiven > numOfElementsBehind ? numOfElementsBehind : radiusGiven;

    let cannotReach = i + radiusGiven + 1; // can't reach without the help

    let shouldBeAtLeast = 1; // The minimal radius required for j
    for(let j = cannotReach ; j < N ; j++){
      // For j, however, should reach the end for comparison
      
      if(A[j] >= shouldBeAtLeast){
        count++;
      }
      shouldBeAtLeast++; // since the point moves to the right
    }

    // if count exceeds 10M
    if(count > 10000000){
      return -1;
    }
  }

  // finally return count
  return count;

}

// Personal
let A = [1, 2, 3, 0];
console.log(solution(A));