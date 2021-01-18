const peek = arr => arr[arr.length - 1];

function solution(n, lost, reserve) {
  const lostPoppedCnt = 0;

  while (lost.length !== 0 && reserve.length !== 0 ) {
    const peekReserve = peek(reserve);
    const peekLost = peek(lost);

    const atLeastReserved = peekReserve - 1;
    const atMostReserved = peekReserve + 1;

    if (peekLost > atMostReserved) {
      lost.pop();
      lostPoppedCnt++;
    }
    else if (peekReserve < atLeastReserved) { // The reserved value is too big
      reserve.pop();
    }
    else {
      lost.pop();
      reserve.pop();
    }
  };

  return n - lostPoppedCnt - lost.length;
}


const n = 5;
const lost = [2, 4];
const reserve = [3];

console.log(solution(n, lost, reserve))