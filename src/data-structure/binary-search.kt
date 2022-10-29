/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    val myArray  = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 122, 400)
    print(" elemento esta na posicao ${recurssao(myArray, 400, 0, myArray.size-1)}")
    
}


// complexidade O(log(n))
fun recurssao( vector: IntArray, index: Int, inicio: Int, fim :Int): Int {
    println(" $inicio, $fim")
    var meio = ((fim+inicio)/2)
    
    if( fim < inicio ) return -1
    
    if(vector[meio] == index) return meio
    
    else if (index > vector[meio]) return recurssao(vector, index, meio+1, fim )
    
    else return recurssao(vector, index, inicio, meio -1 )
}