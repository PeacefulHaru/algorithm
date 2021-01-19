//f This is wrong
//x I have learned that you have to spread the array if you want to copy
//   The fastest way in JS is to spread (ES6)

const peek = arr => arr[arr.length - 1];

function solution(n, lost, reserve) {
  let lostPoppedCnt = 0;

  const pastLost = [...lost];
  lost = lost.filter(el => !reserve.includes(el));
  reserve = reserve.filter(el => !pastLost.includes(el));

  lost.sort();
  reserve.sort();

  while (lost.length > 0 && reserve.length > 0) {
    const peekReserve = peek(reserve);
    const peekLost = peek(lost);

    // console.log(lost + " | " + reserve);
    if (peekLost > peekReserve + 1) {
      lost.pop();
      lostPoppedCnt++;
    }
    else if (peekLost < peekReserve - 1) { // The reserved value is too big
      reserve.pop();
    }
    else {
      lost.pop();
      reserve.pop();
    }
  };

  return n - lostPoppedCnt - lost.length;
}

const n = 6;
const lost = [1, 5, 6];
const reserve = [4, 5];

console.log(solution(n, lost, reserve))