//e : explained code, not for the result based

/**
 * 
 * Learned 
 *  1. You can change the row of matrix if you want. 
 */
const transpose = matrix =>
    matrix.reduce(
        (result, row) => row.map((_, i) => [...(result[i] || []), row[i]]),
        []
    );



    const board = [
      [0,0,0,0,0],
      [0,0,1,0,3],
      [0,2,5,0,1],
      [4,2,4,4,2],
      [3,5,1,3,1]]	
      ;

    console.log(transpose(board).map(row => row.reverse().filter(el => el !== 0)))
