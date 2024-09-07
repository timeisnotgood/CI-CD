
/**
 * @param {number} n
 * @returns { }
*/
//basic hashing

//---------------------------------------------

// const hash = {};

// const num = [1, 2, 1, 3, 2];

// for(let i of num){
//     if(hash[i]){
//         hash[i] += 1 
//     }else{
//         hash[i] = 1 
//     }
// }


// const queries = [1, 3, 4, 2, 10];

// for(let querie of queries){
//     console.log(hash[querie] || 0);
// }

//--------------------------------------------------------

// Character hashing

//using function 

/**
 * @param {string} s 
 * @returns {number} querie
*/


// function charHashing(str, char){
//     let hash = {};
//     for(let i of str){
//         if(hash[i]){
//             hash[i] +=1;
//         }else{
//             hash[i] =1;
//         }
//     }

//     for(let querie of char){
//         console.log(hash[querie] || 0);
//     }
// }



// charHashing("abcdabehf", ['a','g','h','b','c'])



//------------------------------------------------------------------

// 1).Given an array, we have found the number of occurrences of each element in the array.


/**
 * @param {array} arr 
 * @returns {object} hashMap
*/

// function ArrayNumCount( arr ){
//     let hashMap = {};

//     for(let i of arr){
//         if(hashMap[i]){
//             hashMap[i] +=1
//         }else{
//             hashMap[i] =1
//         }
//     }

//     return hashMap;

// }

// console.log(ArrayNumCount([10,5,10,15,10,5]));

// 2). You are given an array arr[] containing positive integers. 
//     These integers can be from 1 to p, and some numbers may be repeated or absent. Your task is to count the frequency of all numbers that lie in the range 1 to n.

function numCount(arr){

    var hash = Array(6)
    
    for(let a of arr){
        if(hash[a]){
            hash[a] +=1
        }else{
            hash[a] = 1
        }
    }

    console.log(hash);
    
}

numCount([2, 3, 2, 3, 5]);

