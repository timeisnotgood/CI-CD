
// basic recurssion
/**
 * @param {number} a
 * @returns { }
*/

function num(a){
    console.log(a);
    if (a == 10) return;
    num(a+1);
}

// num(1);


// class based recursion 
/**
 * @param {number} n
 * @returns { }
*/

class Solution{
    constructor(){}

    printNos(a){
        console.log(a);
        if(a == 10) return;
        this.printNos(a+1);
    }
}

const rec = new Solution;
rec.printNos(1)