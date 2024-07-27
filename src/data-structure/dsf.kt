/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun isBounds(sizeOfRows: Int, sizeOfColumns: Int, toRow: Int, toColumn: Int): Boolean {
    if( toRow < 0 || toColumn < 0) return false
    if( toRow > sizeOfRows-1 || toColumn > sizeOfColumns-1) return false
    return true
}
fun main() {
    val matrix = arrayOf(
        intArrayOf(1,1,1,1),
        intArrayOf(0,0,0,1),
        intArrayOf(1,1,1,1)
    )
    /**
     *
     *   *,*,*,1
         0,0,0,1
         1,1,1,1
     */
    
    val totalOfRows = matrix.size
    val totalOfColumns = matrix[0].size
    
    val srcI = 0
    val srcJ= 0
    val targetI = 2
    val targetJ = 0
    
    // direction
    //  0,0 -> 0,1 -> 0,2
    //   |      |      |
    //  1,0 <- 1,1 -> 1,2
    //.  |      |      |
    //. 2,0 -> 2,1 -> 2,2
    
    val directionUp = intArrayOf(-1,0)
    val directionDown = intArrayOf(1,0)
    val directionLeft = intArrayOf(0,-1)
    val directionRigth = intArrayOf(0, 1)
    val directions = arrayOf(directionUp, directionDown, directionLeft, directionRigth )
    
    val visitedValues = mutableSetOf<String>()
    val queue = mutableListOf<IntArray>()
    queue.add(intArrayOf(0,0,0))
    // sample
    //from 0,0 to rigth is 0,1
    // from 1,3 to left is 1,2
    while(queue.size > 0) {
        val child = queue.removeAt(0)
        val row = child[0]
        val column = child[1]
        
        for( d in directions) {
                val newRow = row + d[0]
                val newColumn = column + d[1]
                
                if(isBounds(totalOfRows, totalOfColumns, newRow, newColumn)) {
                    val key = "${newRow}-${newColumn}"
                    
                    val node = intArrayOf(newRow, newColumn, child[2]+1)
                    if(matrix[newRow][newColumn]== 1 && !visitedValues.contains(key)) {
                        visitedValues.add(key)
                     	println(key)
                        queue.add(node)
                    }
                    
                   if(targetI == newRow && targetJ == newColumn) {
                       println("AqUI ${node[2]}")
                   } 
                }
     
    }
    }
            
    
}