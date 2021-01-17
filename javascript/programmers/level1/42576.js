function solution(participant, completion) {

  participant.sort();
  completion.sort();

  console.log(participant);
  console.log(completion)
  for (let i in completion) {
    if (participant[i] !== completion[i]) return participant[i];
  }
  return participant[participant.length - 1];
}

// you can actually do
// for (let i in participant)
// And delete the 11th sentence, since value !== undefined anyway. (Cool Stuff)

const participant = ["mislav", "stanko", "mislav", "ana"]
const completion =["stanko", "ana", "mislav"]	

console.log(solution(participant, completion));
