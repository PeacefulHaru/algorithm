/**
 * You are given two non-empty arrays A and B consisting of N integers. 
 * Arrays A and B represent N voracious fish in a river, ordered downstream
 *  along the flow of the river.

The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, 
then fish P is initially upstream of fish Q. Initially, each fish has a
 unique position.


If two fish move in opposite directions and there are no other (living)
 fish between them, they will eventually meet each other. Then only one
  fish can stay alive − the larger fish eats the smaller one. More 
  precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 
  and B[Q] = 0, and there are no living fish between them. After they meet:

If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
We assume that all the fish are flowing at the same speed. That is, 
fish moving in the same direction never meet. The goal is to calculate 
the number of fish that will stay alive.

For example, consider arrays A and B such that:

  A[0] = 4    B[0] = 0
  A[1] = 3    B[1] = 1
  A[2] = 2    B[2] = 0
  A[3] = 1    B[3] = 0
  A[4] = 5    B[4] = 0
Initially all the fish are alive and all except fish number 1 are moving
 upstream. Fish number 1 meets fish number 2 and eats it, then it meets
  fish number 3 and eats it too. Finally, it meets fish number 4 and is
   eaten by it. The remaining two fish, number 0 and 4, never meet and 
   therefore stay alive.

Write a function:

function solution(A, B);

that, given two non-empty arrays A and B consisting of N integers, 
returns the number of fish that will stay alive.

For example, given the arrays shown above, the function should return 2, 
as explained above.


 * 
 */

function solution(A, B) {
  // write your code in JavaScript (Node.js 8.9.4)

  let N = A.length; // = B.length;
  
  if(N <= 1){
    // handles one fish. (N >= 1 is given)
    return N;
  }

  // Can assume N >= 2 following.
  
  let removedFishCount = 0;

  for(let i = 0; i < A.length-1 ; i++){
    // Testing 
    console.log(B + " i=" + i);

    // Remove the fish out of an array, if direction is 0.
    while(B[0] === 0){ // Upstream
      A.splice(0, 1); 
      B.splice(0, 1);
      removedFishCount++;
    }

    // Remove the last fish with the direction '1'
    while(B[B.length - 1] === 1){ //Downstream
      A.pop();
      B.pop();
      removedFishCount++;
    }

    // Go straight to fight scene
    i = B.indexOf(0) - 1;

    let firstFishDir = B[i];
    let secondFishDir = B[i+1];


    if(firstFishDir === 1 && secondFishDir === 0){
      //They meet!
      let firstFishLength = A[i];
      let secondFishLength = A[i+1];

      if(firstFishLength > secondFishLength){
        // First Fish wins!

        // Removes both the size and direction
        A.splice(i + 1, 1); 
        B.splice(i + 1, 1);

        // And should check again with the next fish
        i--;

      }else{
        // You can assume they are never equal, with the given assumption following
        // elements of the array are unique, and cannot be the same
        A.splice(i, 1);
        B.splice(i, 1);

        // if first fish loses, go back one step
        // since i++ is the default, do the '-2'
        i = 0 > i - 2 ? -1 : i - 2;
      }
    }
  }

  // if everything is done, simply return numbers of fish by
  return A.length + removedFishCount;

}


// Persona

let A = [1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16];
let B = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0];
// let S = "{[()()]}";
console.log(solution(A, B));