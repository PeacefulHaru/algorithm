/**
 * 
 * 
 * 
 */

function solution(S) {
  // write your code in JavaScript (Node.js 8.9.4)
  let N = S.length;

  // handle 0
  if(N === 0){
    return 1;
  }
  if(N % 2 !== 0){
    //if not even
    return 0;
  }

  //Assume N is even number
  //Assume 2 <= N <= 200,000 

  let arr = [];

  let pairingProperity = {
    "}": "{",
    ")": "(",
    "]": "["
  }

  for (let char of S){
    // Testing
    // console.log(arr);

    if(char === "{" || char === "(" || char === "[") {
      // opening tag
      arr.push(char);
    }else{
      // closing tag (With the given assumption following)
      // string S consists only of the 
      //following characters: "(", "{", "[", "]", "}" and/or ")".

      // check if it is proper closing tag
      let checkingTarget = arr.pop();

      if(checkingTarget !== pairingProperity[char]){
        return 0;
      }
    }
  }

  

  if(arr.length > 0){
    // if theres are still unpaired elements, it means it failed.
    return 0;

  }else{
    // if it all passes the test, it means it satisfies
    return 1;
  }
}

// Personal
// let A = [0,0,0,0,1,1,1];
let S = "{[()()]}";
console.log(solution(S));