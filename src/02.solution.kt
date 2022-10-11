
fun solution(palindromo: String): Boolean {
    val size = palindromo.length
    val max_limit = 10 * 10 *10 * 10 * 10
    return if (  size >=1 && size <= max_limit ) {
        palindromo.reversed().equals(palindromo)
    } else {
        false
    }
}
