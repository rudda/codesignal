class Solution {
    //-231 <= x <= 231 - 1

    fun checkContraints(x: Long) : Boolean {
        val intMinValue = -2.0.pow(31).toLong()
        val intMaxValue = (2.0.pow(31) - 1).toLong()
        return x in intMinValue+1 until intMaxValue
    }

    fun reverse(x: Int): Int {
        if(!checkContraints(x.toLong())) return 0

        var x2 = x
        var isNegative = false
        x2 = if( x < 0) {
            isNegative = true
            x.times(-1)
        } else {
            x
        }
        // test-case 1 : x < 10 = x // 1 ->1, 2-> 2, ... 9 -> 9, -1 -> -1 
        if(x2 < 10) {
            return x
        }
        // test-case 2 : x = -20 //  -2
        // test-case 3: x= [-10, 10, -2000, -30] -> [-1,1,-2,-3]
        //hint: I need to check how many decimal place a number has and
        // if this number divided by 10, 100, 1000 etc.. is a perfect division I need to discard zeros from left

        val howManyDecimalPlaces = x2.toString().length
        val base = 10.0.pow(howManyDecimalPlaces -1)
        val itIsAZeroToLeftNumber = (x2 % base.toInt()) == 0

        if(itIsAZeroToLeftNumber) {
            val response =  (x2 / base.toInt())
            return if(isNegative) {
                response.times(-1)
            }else {
                response
            }
        }

        // other cases
        var reversed = "" // I could to use string.reversed()
        val x2String = x2.toString()

        for( i in x2String.length -1 downTo 0) {
            reversed+= x2String[i].toString()
        }

        return if(isNegative) {
            val pre_response = reversed.toLong()
            if(checkContraints(pre_response)) {
                pre_response.toInt().times(-1)
            } else {
                return 0
            }
        } else {
            val pre_response = reversed.toLong()
            if(checkContraints(pre_response)) {
                pre_response.toInt()
            } else {
                return 0
            }
        }
        return 0;
    }
}