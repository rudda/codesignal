class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // Inicializa um array para armazenar a quantidade mínima de moedas necessárias para cada quantia de 0 até amount
        // Inicialmente, definimos todas as posições como amount + 1 (representando "infinito" ou "impossível")
        // Pois é impossível formar qualquer quantia com amount + 1 moedas (a quantia máxima que queremos formar é amount)
        val coinChangeValues = IntArray(amount + 1) { amount + 1 }
        
        // Base case: 0 moedas são necessárias para formar a quantia 0
        coinChangeValues[0] = 0

        // Itera sobre cada quantia de 1 até amount para determinar o número mínimo de moedas necessárias
        for (i in 1 until coinChangeValues.size) {
            // Para cada quantia, verifica cada moeda disponível
            for (c in coins) {
                // Verifica se a moeda atual pode ser usada para formar a quantia i
                if (i - c >= 0) {
                    // Calcula a quantidade mínima de moedas necessárias para formar a quantia i
                    // Considera a quantidade de moedas necessária para formar a quantia i - c e adiciona uma moeda de valor c
                    coinChangeValues[i] = minOf(coinChangeValues[i], coinChangeValues[i - c] + 1)
                }
            }
        }

        // Verifica se é possível formar a quantia amount
        // Se o valor em coinChangeValues[amount] ainda for amount + 1, significa que não foi possível formar a quantia
        // Caso contrário, retorna o número mínimo de moedas necessário para formar a quantia amount
        return if (coinChangeValues[amount] != amount + 1) coinChangeValues[amount] else -1
    }
}