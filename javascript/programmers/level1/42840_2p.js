
function solution(answers) {
  const a = [1, 2, 3, 4, 5];
  const b = [2, 1, 2, 3, 2, 4, 2, 5];
  const c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  // a person correction = ac
  const ac = answers.filter((el, i) => el === a[i % a.length]).length;
  const bc = answers.filter((el, i) => el === b[i % b.length]).length;
  const cc = answers.filter((el, i) => el === c[i % c.length]).length;
  const max = Math.max(ac, bc, cc);

  const answer = [];
  if (ac === max) answer.push(1);
  if (bc === max) answer.push(2);
  if (cc === max) answer.push(3);

  return answer;
}


const answers = [1,3,2,4,2]	;
console.log(solution(answers));