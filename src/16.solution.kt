class Solution {
    fun isPalindrome(x: Int): Boolean {
        val xString = x.toString()
        var reversedX = ""
        
        
        if (x < 0) return false

        if(xString.length ==1 ){
            return true
        }


        for( i in xString.length -1 downTo 0) {
            reversedX+= xString[i]
        }

        for( (index,x) in xString.withIndex()){
            
            if(x != reversedX[index]) {
               return  false
            }
            
        }

        return true
    }
}