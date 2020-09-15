
function solution(S) {
  // write your code in JavaScript (Node.js 8.9.4)

  // console.log('a'.charCodeAt(0)) // 97
  const N = S.length;
  
  // Skip the last one (If reached last, delete the last)
  for(let i = 0; i < S.length -1; i ++) {
    let target = S[i].charCodeAt(0);
    let nextTarget = S[i + 1].charCodeAt(0);

    if(target > nextTarget) {
      // abnormal, remove then end.
      return S.slice(0, i) + S.slice(i + 1, N);
      // str.slice(0, 3) + str.slice(4);
    }
  }

  // if it has failed to return value, 
  // it defines you can safely delete the last value.
  return S.slice(0, N - 1);
}

// execution
// A = [1, 2, 3]
// B = [4, 5, 6]
// K = 5
S = "absdlnjgfdfjgnojdmngodnmgkdnkgndkfgmdklgnkdlngkodnfgkodngkjoedngkodngkondkogndfjkgndjkognksjldfnkoj"
console.log(solution(S))