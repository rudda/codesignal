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
    
    fun getNumberFromList(list: ListNode): Long {
        val reversedList = mutableListOf<Int>()
        var node: ListNode? = list
        while(node != null) {
            reversedList.add(node.`val`!!)
            node = node.next
        }
        
        var counter = 0
        var response = 0L;

        for( i in reversedList) {
            val calc = i * 10.0.pow(counter).toLong()
            println("calc:::: $calc")
            response += calc
            counter++
        }
        
        return response
    }
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
       val num1 = getNumberFromList(l1!!)
       val num2 = getNumberFromList(l2!!)
       println("Sum ($num1 + $num2") 
       val sum = num1.plus(num2)
       val sumString = sum.toString()

       val head =  ListNode(sumString.last().toString().toInt()) 
       var node = head
       for( i in sumString.length - 2 downTo 0) {
           
            val newNode = ListNode(sumString[i].toString().toInt())
            node.next = newNode
            node = newNode
       } 
       

       return head
    }
}