// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
  // write your code in JavaScript (Node.js 8.9.4)
  let answer = 0;
  
  // logic begins *****
  let newArr = A
    .filter(element => element >= 1) // only handles 1 or bigger.
    .sort((a, b) => {
      if(a > b) return 1;
      if(a < b) return -1;
      return 0;
    })

  // if newArr is blank then, return 1
  if(newArr.length === 0) return 1;

  let i = 1;
  newArr.forEach(element => {
    if(i === element){ //it means it exists
      i++;
    }
    else{ //does not exist and therefore the answer.
      return i;
    }
  });

  return i;
}

// Testing **** DELETE THIS FOR THE SUBMIT  
let theArray = [1 , 4 , 2, 3, 5, -2, 127317823,7,6  ];
console.log(solution(theArray));