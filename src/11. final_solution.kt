package matrizRotation

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
    //println("newAddress: canIMoveTo: ${newAddress.toString()}")
    //println("Indices ${matrix.indices} - ${matrix[0].indices} ")
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

fun matrixRotation( originalMatrix: Array<Array<Int>>, r: Int): Unit {
    // Write your code here
    var matrix = originalMatrix
    val rowCount = matrix.size
    val columnCount = matrix[0].size
    val copyMatrix = Array(rowCount) { Array(columnCount) { 0 } }


    val mapDirections = arrayOf(EDirections.DOWN, EDirections.RIGHT, EDirections.UP, EDirections.LEFT)
    val mainDiagonal = mutableListOf<MutablePair>()
    val layers = Math.min(rowCount, columnCount) / 2

    // diagonal principal
    for( i in 0 until layers) {
        mainDiagonal.add(MutablePair(i,i))
    }

    // how many rotations ?
    for( shift in 0 until r) {
        println("shift: $shift")
        for( diagonal in mainDiagonal ) {

           println("\n digonal principal ${diagonal.toString()} \n \n")

            var address = diagonal;
            for (direction in mapDirections) {

                while( canIMoveTo(address, matrix, direction)) {

                    val newAddress = moveTo(address, matrix, direction)
                    //

                    if( newAddress.first != -1 && newAddress.second != -1) {

                        if(!movesMap.containsKey(newAddress)) {

                            movesMap.put(newAddress, true)
                            copyMatrix[newAddress.first][newAddress.second] = matrix[address.first][address.second]
                            address =  newAddress;
                            //println("Im ${address.toString()} and I could move to ${newAddress.toString()}")
                            //println("I was moved")

                        } else {
                            break;
                        }

                    } else {
                        break;
                    }

                }
            }
        }
        println("\n\n Parcial Result: $shift / ${r - 1} \n\n\n")

        println(" Original Result:")
        for (row in matrix) {
            println(row.joinToString(" "))
        }
        println("Result:")
        for (row in copyMatrix) {
            println(row.joinToString(" "))
        }

        // clearing the moves for other round
        movesMap.clear()
        // update matrix with the content of CopyMatrix
        for (i in copyMatrix.indices) {
            for (j in copyMatrix[i].indices) {
                matrix[i][j] = copyMatrix[i][j]
            }
        }
    }


    println()
    println()
    println()
    println()
    println()
    movesMap.clear()

}

fun main(args: Array<String>) {
    //case1()

    case2()

}

fun case1(){
    val rows = 4
    val columns = 4
    val r = 1
    val matrix_case_1 = arrayOf(
        arrayOf(1, 2, 3, 4),
        arrayOf(5, 6, 7, 8),
        arrayOf(9, 10, 11, 12),
        arrayOf(13, 14, 15, 16)
    )


    matrixRotation(matrix_case_1, r)
}

/*
Input:
    5 4 7

    1 2 3 4
    7 8 9 10
    13 14 15 16
    19 20 21 22
    25 26 27 28
Out:

28 27 26 25
22 9 15 19
16 8 21 13
10 14 20 7
4 3 2 1
    */
fun case2() {

    val rows = 5
    val columns = 4
    val r = 7
    val matrix_case_1 = arrayOf(
        arrayOf(1, 2, 3, 4),
        arrayOf( 7, 8, 9, 10),
        arrayOf(13, 14, 15, 16),
        arrayOf(19, 20, 21, 22),
        arrayOf(25, 26, 27, 28)
    )


    matrixRotation(matrix_case_1, r)

}


// input:
//4 4 1
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16