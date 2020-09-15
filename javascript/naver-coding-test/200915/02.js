

function solution(N) {
  // write your code in JavaScript (Node.js 8.9.4)

  if (N > 0) {
    // handle when it is positive integer
    let nStr = N.toString().split("");
    for(let i = 0; i < nStr.length; i++) {
      // console.log(parseInt(nStr[i]))
      if(parseInt(nStr[i]) < 5) {
        nStr.splice(i, 0, '5');
        return parseInt(nStr.join(''));
      }
    }
    // if it fails, you can add the 5 at last
    return N * 10 + 5;

  } else if (N === 0) {
    // simply handle when N == 0
    return 50;

  } else {
    // handle when it is negative (it is opposite)
    let nStr = N.toString().slice(1).split("");
    for(let i = 0; i < nStr.length; i++) {
      if(parseInt(nStr[i]) > 5) {
        nStr.splice(i, 0, '5');
        return parseInt(nStr.join('')) * -1;
      }
    }
    //if it fails to return, you put the 5 at last
    return N * 10 - 5;
  }
}


// execution
// A = [1, 2, 3]
// B = [4, 5, 6]
// K = 5
N = -999 // -8,000 ~ 8,000 for N

console.log(solution(N));