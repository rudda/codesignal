fun encontrarMedianaArraysOrdenados(array1: IntArray, array2: IntArray): Double {
    val tamanho1 = array1.size
    val tamanho2 = array2.size
    if (tamanho1 > tamanho2) {
        return encontrarMedianaArraysOrdenados(array2, array1) // Garantir que array1 é o menor
    }

    var inicio = 0
    var fim = tamanho1
    val metadeTotal = (tamanho1 + tamanho2 + 1) / 2

    while (inicio <= fim) {
        val posicao1 = (inicio + fim) / 2
        val posicao2 = metadeTotal - posicao1

        when {
            posicao1 < tamanho1 && array2[posicao2 - 1] > array1[posicao1] -> inicio = posicao1 + 1 // posicao1 é muito pequena
            posicao1 > 0 && array1[posicao1 - 1] > array2[posicao2] -> fim = posicao1 - 1 // posicao1 é muito grande
            else -> { // posicao1 é perfeita
                val maxEsquerda = when {
                    posicao1 == 0 -> array2[posicao2 - 1]
                    posicao2 == 0 -> array1[posicao1 - 1]
                    else -> maxOf(array1[posicao1 - 1], array2[posicao2 - 1])
                }

                if ((tamanho1 + tamanho2) % 2 == 1) {
                    return maxEsquerda.toDouble() // Se ímpar, retorna a mediana diretamente
                }

                val minDireita = when {
                    posicao1 == tamanho1 -> array2[posicao2]
                    posicao2 == tamanho2 -> array1[posicao1]
                    else -> minOf(array1[posicao1], array2[posicao2])
                }

                return (maxEsquerda + minDireita) / 2.0
            }
        }
    }

    throw IllegalArgumentException("Os arrays de entrada não estão ordenados ou têm tamanhos inválidos.")
}
