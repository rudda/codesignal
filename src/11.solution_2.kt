import java.io.*
import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

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
    return when (direction) {
        EDirections.DOWN -> MutablePair(row + 1, col)
        EDirections.RIGHT -> MutablePair(row, col + 1)
        EDirections.UP -> MutablePair(row - 1, col)
        EDirections.LEFT -> MutablePair(row, col - 1)
    }
}

private fun canIMoveTo(from: MutablePair, matrix: Array<Array<Int>>, direction: EDirections): Boolean {
    val newAddress = moveToDirection(from, direction)
    if (newAddress.first !in matrix.indices || newAddress.second !in matrix[0].indices) {
        return false
    }
    return true
}

fun moveTo(from: MutablePair, matrix: Array<Array<Int>>, direction: EDirections): MutablePair {
    if (canIMoveTo(from, matrix, direction)) {
        return moveToDirection(from, direction)
    }
    return MutablePair(-1, -1)
}

fun matrixRotation(matrix: Array<Array<Int>>, r: Int): Unit {
    val rowCount = matrix.size
    val columnCount = matrix[0].size
    val copyMatrix = Array(rowCount) { Array(columnCount) { 0 } }

    val layers = Math.min(rowCount, columnCount) / 2

    for (layer in 0 until layers) {
        val elements = mutableListOf<Int>()
        
        // Extract the elements of the layer into a list
        for (i in layer until columnCount - layer) {
            elements.add(matrix[layer][i])
        }
        for (i in layer + 1 until rowCount - layer) {
            elements.add(matrix[i][columnCount - layer - 1])
        }
        for (i in columnCount - layer - 2 downTo layer) {
            elements.add(matrix[rowCount - layer - 1][i])
        }
        for (i in rowCount - layer - 2 downTo layer + 1) {
            elements.add(matrix[i][layer])
        }
        
        val rotatedElements = elements.mapIndexed { index, _ -> elements[(index + r) % elements.size] }

        var idx = 0
        
        // Place the rotated elements back into the correct positions in the copyMatrix
        for (i in layer until columnCount - layer) {
            copyMatrix[layer][i] = rotatedElements[idx++]
        }
        for (i in layer + 1 until rowCount - layer) {
            copyMatrix[i][columnCount - layer - 1] = rotatedElements[idx++]
        }
        for (i in columnCount - layer - 2 downTo layer) {
            copyMatrix[rowCount - layer - 1][i] = rotatedElements[idx++]
        }
        for (i in rowCount - layer - 2 downTo layer + 1) {
            copyMatrix[i][layer] = rotatedElements[idx++]
        }
    }
    
    for (row in copyMatrix) {
        println(row.joinToString(" "))
    }
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = first_multiple_input[0].toInt()

    val n = first_multiple_input[1].toInt()

    val r = first_multiple_input[2].toInt()

    val matrix = Array(m) { Array(n) { 0 } }
    
    for (i in 0 until m) {
        matrix[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    matrixRotation(matrix, r)
}
