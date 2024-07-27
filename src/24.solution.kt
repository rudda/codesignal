
fun main() {
    val arr1 = intArrayOf(1, 2, 3, 5, 6, 7)
    val arr2 = intArrayOf(3, 6, 7, 8, 20) 
    val map = mutableSetOf<Int>()
    
    for( a1 in arr1) {
        for(a2 in arr2) {
            if( a1 == a2) {
                map.add(a1)
            }
        }
    }
   
    
    return map.toIntArray()
    
}