// x: of defines the value, in: defines the index of for loop
// x2: learned initializing array 

// Wording is so important ..

function solution(board, moves) {
  let answer = 0;
  const N = board.length;
  const top = Array(N).fill(N); // This can be slower than let a = new Array(n); for (let i=0; i<n; ++i) a[i] = 0; (But simpler)
  const picked = [];

  // if empty, then the value will be 0, and therefore should do NOTHING
  // This loop scans the board and results a top array filled with the position of the first member to be picked
  for (let i in board) {
    for (let j in board[i]) {
      if (top[j] === N && board[i][j] !== 0) {
        top[j] = Number(i)
      }
    }
  }

  // Testing
  // console.log(top);

  // This does not change the board data
  // if top == N, it means it is done picking
  for (const move of moves) {
    const i = top[move - 1];
    const j = move - 1; // because move starts from 1 always.

    // Dolls.
    let typeOfDoll;
    if (i !== N) typeOfDoll = board[i][j];
    const pickedArrPeekValue = picked.length - 1 < 0 ? undefined : picked[picked.length - 1] // peek fucntion;

    // Following handles the stack 
    if (i === N) {
      // does nothing (This is only for the readability)
    }
    else if (typeof pickedArrPeekValue === 'undefined' || pickedArrPeekValue !== typeOfDoll) {
      // if picked is not 0, and if the picked is empty or top picked one is not the same, just push.
      picked.push(typeOfDoll);
      top[move - 1] = i + 1; // add unitl it becomes N
    } 
    else {
      picked.pop();
      answer += 2;
      top[move - 1] = i + 1; // add unitl it becomes N
    }
    // console.log("top: " + top);
    // console.log("answer: " + answer);
    // console.log("picked: " + picked);
  }

  return answer;
}

board = 	[
  [1, 0, 0, 0, 0], 
  [1, 0, 0, 0, 5], 
  [1, 0, 0, 0, 5], 
  [1, 0, 0, 0, 5], 
  [1, 1, 0, 0, 5]
]	;
moves = [1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2];

console.log(solution(board, moves));
