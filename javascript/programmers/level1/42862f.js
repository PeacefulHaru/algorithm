const peek = arr => arr[arr.length - 1];

function solution(n, lost, reserve) {
  const lostPoppedCnt = 0;

  while (lost.length !== 0 && reserve.length !== 0 ) {
    const peekReserve = peek(reserve);
    const peekLost = peek(lost);

    lost.sort();
    reserve.sort();

    // console.log(reserve + " | " + lost);
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


const n = 5;
const lost = [1, 2, 3, 4];
const reserve = [5];

console.log(solution(n, lost, reserve))