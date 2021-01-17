const personOne = n => n % 5 === 0 ? 5 : n % 5;

const personTwo = n => {
  if (n % 2 !== 0) return 2;
  n = (n / 2) % 4;

  if (n === 1) return 1;
  if (n === 0) return 5;
  return n + 1;
} 

const personThree = n => {
  const repeat = [3, 1, 2, 4];
  n = Math.ceil(n / 2) % 5;
  if (n === 0) return 5;
  return repeat[n - 1];
}


function solution(answers) {
  const correction = [0, 0, 0];

  answers.forEach((answer, i) => {
    if (answer === personOne(i + 1)) correction[0]++;
    if (answer === personTwo(i + 1)) correction[1]++;
    if (answer === personThree(i + 1)) correction[2]++;
    console.log(correction)
  });

  let max = 0;
  const answer = [];

  correction.forEach(el => {
    if (el > max) max = el;
  })
  correction.forEach((el, i) => el === max ? answer.push(i + 1) : null);

  return answer;
}

const answers = [1,3,2,4,2]	;
console.log(solution(answers));
