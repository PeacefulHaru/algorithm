const transpose = matrix => 
  matrix.reduce(
    (result, row) => row.map((el, i) => [...result[i] || [], el]), // first element of reduce
    [] // second element of reduce
  ); // end of reduce


function solution(board, moves) {
  const stacks = transpose(board).map(row => row.reverse().filter(el => el !== 0));
  const basket = [];
  var answer = 0;

  for (const move of moves) {
    const pop = stacks[move - 1].pop();

    if(typeof pop === 'undefined') continue;
  
    if(pop === basket[basket.length - 1]) {
      basket.pop();
      answer += 2;
      continue;
    }

    basket.push(pop);    
  }
  
  return answer;
}

const board = [
  [0,0,0,0,0],
  [0,0,1,0,3],
  [0,2,5,0,1],
  [4,2,4,4,2],
  [3,5,1,3,1]
];

const moves =  [1,5,3,5,1,2,1,4]	;

console.log(solution(board, moves));
