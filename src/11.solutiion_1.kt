import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'matrixRotation' function below.
 *
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY matrix
 *  2. INTEGER r
 */


enum class EDirections {
    DOWN,
    LEFT,
    UP,
    RIGHT
}

data class MutablePair(var first: Int, var second: Int)

val movesMap: HashMap<MutablePair, Boolean> = hashMapOf()


private fun moveToDirection(from: MutablePair, direction: EDirections): MutablePair {
    val (row, col) = from
    return  when (direction) {
        EDirections.DOWN -> MutablePair(row + 1, col)
        EDirections.RIGHT -> MutablePair(row, col + 1)
        EDirections.UP -> MutablePair(row - 1, col)
        EDirections.LEFT -> MutablePair(row, col - 1)
    }
}

private fun canIMoveTo(from: MutablePair, matrix: Array<Array<Int>>, direction: EDirections): Boolean {
    
    val newAddress = moveToDirection(from, direction)
    // Check if the new position is within the bounds of the matrix
    if (newAddress.first !in matrix.indices || newAddress.second !in matrix[0].indices) {
        return false
    }

    return true
}

fun moveTo(from: MutablePair, matrix: Array<Array<Int>>, direction: EDirections ): MutablePair {
    
    if( canIMoveTo(from, matrix, direction)) {
        return moveToDirection(from, direction)
    }
    
    return MutablePair(-1,-1);
}

fun matrixRotation(matrix: Array<Array<Int>>, r: Int): Unit {
    // Write your code here
    val rowCount = matrix.size
    val columnCount = matrix[0].size
    val copyMatrix = Array(columnCount) { Array(rowCount) { 0 } }
     
    
    val mapDirections = arrayOf(EDirections.DOWN, EDirections.RIGHT, EDirections.UP, EDirections.LEFT)
    val mainDiagonal = mutableListOf<MutablePair>() 
    
    
    for( i in 0 until rowCount) {
        for( j in 0 until columnCount ) {
            if( i == j) {
                mainDiagonal.add(MutablePair(i,j))
            }
        }
    }
    
    for( shift in 0 until r) {

        for( diagonal in mainDiagonal ) {
            
            var address = diagonal;
            for (direction in mapDirections) {
                
                while( canIMoveTo(address, matrix, direction)) {
                    val newAddress = moveTo(address, matrix, direction)
                    if( newAddress.first != -1 && newAddress.second != -1) {
                        
                        if(!movesMap.containsKey(newAddress)) {
                            
                            movesMap.put(newAddress, true)
                            copyMatrix[newAddress.first][newAddress.second] = matrix[address.first][address.second]
                            address =  newAddress;
                            
                        } else {
                            break;
                        }
                        
                    } else {
                        break;
                    }
                    
                }
            }
        }
        
    }
    
    for (row in copyMatrix) {
        println(row.joinToString(" "))
    }
       
    movesMap.clear()
    
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val r = first_multiple_input[2].toInt()

    val matrix = Array<Array<Int>>(m, { Array<Int>(n, { 0 }) })
   
    
    for (i in 0 until m) {
        matrix[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    matrixRotation(matrix, r)
}
