/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    
    fun getNumberFromList(list: ListNode): Int {
        val reversedList = mutableListOf<Int>()
        var node: ListNode? = list
        while(node != null) {
           
            reversedList.add(node.`val`!!)
            node = node.next
        }
        
        var counter = 0
        var response = 0;

        for( i in reversedList.size.minus(1) downTo 0) {
            response += reversedList[i] * 10.0.pow(counter).toInt()
            counter++
        }

        return response
    }
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
       val num1 = getNumberFromList(l1!!)
       val num2 = getNumberFromList(l2!!)

       val sum = num1.plus(num2)
       val sumString = sum.toString()
        
       

       val head =  ListNode(sumString.last().toString().toInt()) 
       var node = head
       for( i in sumString.length - 2 downTo 0) {
            println("${sumString[i].toString().toInt()} ")
            val newNode = ListNode(sumString[i].toString().toInt())
            node.next = newNode
            node = newNode
       } 
       

       return head
    }
}