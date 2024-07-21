class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p = l1
        var q = l2
        var carry = 0
        val dummyHead = ListNode(0)
        var current = dummyHead
        
        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        
        if (carry > 0) {
            current.next = ListNode(carry)
        }
        
        return dummyHead.next
    }
}

fun main() {
    // Função de utilidade para criar a lista ligada a partir de uma lista de inteiros
    fun createListNode(vararg values: Int): ListNode? {
        val head = ListNode(values[0])
        var current = head
        for (i in 1 until values.size) {
            current.next = ListNode(values[i])
            current = current.next!!
        }
        return head
    }

    // Função de utilidade para imprimir a lista ligada
    fun printListNode(node: ListNode?) {
        var current = node
        while (current != null) {
            print("${current.`val`} ")
            current = current.next
        }
        println()
    }

    // Teste
    val l1 = createListNode(9)
    val l2 = createListNode(1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9)
    val solution = Solution()
    val result = solution.addTwoNumbers(l1, l2)
    printListNode(result) // Saída esperada: 0 0 0 0 0 0 0 0 0 0 1
}
