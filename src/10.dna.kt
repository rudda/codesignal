fun main(args: Array<String>) {
    // Reading the total number of genes
    val n = readLine()!!.trim().toInt()
    
    // Reading the beneficial genes
    val genes = readLine()!!.trimEnd().split(" ").toTypedArray()
    
    // Reading the health values of the genes
    val health = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    
    // Reading the number of DNA strands
    val s = readLine()!!.trim().toInt()

    // To store the total health of all DNA strands
    var minHealth = Int.MAX_VALUE
    var maxHealth = Int.MIN_VALUE

    for (sItr in 1..s) {
        // Reading the input for each DNA strand
        val firstMultipleInput = readLine()!!.trimEnd().split(" ")
        val start = firstMultipleInput[0].toInt()
        val end = firstMultipleInput[1].toInt()
        val d = firstMultipleInput[2]

        // Calculating the total health of the current DNA strand
        val totalHealth = calculateHealth(genes, health, start, end, d)

        // Updating the minimum and maximum health values
        if (totalHealth < minHealth) {
            minHealth = totalHealth
        }
        if (totalHealth > maxHealth) {
            maxHealth = totalHealth
        }
    }

    // Printing the result
    println("$minHealth $maxHealth")
}

fun calculateHealth(genes: Array<String>, health: Array<Int>, start: Int, end: Int, dna: String): Int {
    var totalHealth = 0
    for (i in start..end) {
        val gene = genes[i]
        val geneHealth = health[i]
        var index = dna.indexOf(gene)
        while (index != -1) {
            totalHealth += geneHealth
            index = dna.indexOf(gene, index + 1)
        }
    }
    return totalHealth
}
