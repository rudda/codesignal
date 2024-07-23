class Solution {
    //-231 <= x <= 231 - 1

    // Verifica se um valor está dentro dos limites de um inteiro de 32 bits
    private fun checkConstraints(x: Long): Boolean {
        val intMinValue = Int.MIN_VALUE.toLong()
        val intMaxValue = Int.MAX_VALUE.toLong()
        //return x in intMinValue..intMaxValue
        return x in intMinValue+1 until intMaxValue
    }


    fun reverse(x: Int): Int {
        if (!checkConstraints(x.toLong())) return 0

        var x2 = if (x < 0) -x else x
        val isNegative = x < 0

        // Caso especial: se x < 10 ou x > -10, retorna o próprio x
        if (x2 < 10) {
            return x
        }

        // Remove zeros à esquerda e reverte o número
        var reversed = 0L
        while (x2 > 0) {
            val pop = x2 % 10
            x2 /= 10
            if (reversed > (Int.MAX_VALUE - pop) / 10) return 0 // Verificação de overflow
            reversed = reversed * 10 + pop
        }

        if (!checkConstraints(reversed)) return 0

        return if (isNegative) -reversed.toInt() else reversed.toInt()
    }
}