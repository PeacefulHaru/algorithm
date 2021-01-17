function solution(numbers) {
  const temp = []

  for (let i = 0; i < numbers.length; i++) {
      for (let j = i + 1; j < numbers.length; j++) {
          temp.push(numbers[i] + numbers[j])
      }
  }

  const answer = [...new Set(temp)]

  return answer.sort((a, b) => a - b)

}


const numbers = [2,1,3,4,1];
// const numbers = [5,0,2,7];
console.log(solution(numbers));

const mySet = new Set();

mySet.add(5);
mySet.add(5);
mySet.add(7);
console.log( mySet);
console.log([...mySet]);