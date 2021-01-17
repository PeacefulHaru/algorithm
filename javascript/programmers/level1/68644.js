
function solution(numbers) {
  var answer = [];
  for (let i = 0; i < numbers.length - 1; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      answer.push(numbers[i] + numbers[j]);
    }
  }

  answer.sort((a, b) => a - b);

  for (let i = 0; i < answer.length - 1; i++) {
    if (answer[i] === answer[i + 1]) {
      answer.splice(i, 1);
      i--;
    }
  }

  return answer;
}


const numbers = [2,1,3,4,1];
// const numbers = [5,0,2,7];
console.log(solution(numbers));