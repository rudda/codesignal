class Solution {
    
    fun passThePillow(n: Int, time: Int): Int {
        // O (1)
        // runTime
        // 119ms
        // 84.36
        // memory 
        // 35 mb
        // 51.74%
        val loops = time / (n-1)
        val increment = loops %2  == 0 
        val howMuch = time % (n-1)

        return if(increment) {
            (1 + howMuch)
        } else {
            n - howMuch
        }

        // ---------------
        // 124 ms
        // 61.58
        // O(n)

        // var index = 1
        // var currentTime =1
        // var increment = true

        // while( currentTime <= time) {
            
        //     if( index == 1) {
        //         increment= true
        //     } else if( index == n) {
        //         increment = false
        //     }
        //     index = if(increment) index+1 else index -1

        //     currentTime++
        // }

        // return index;    
    }

    // 1 2 3 4 
    //   X X X
    //   X X

     // 1 2 3 4 
    //    X X X
    //  X X X 
    //  X X X *

   



    
}