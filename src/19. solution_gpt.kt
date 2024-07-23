class Logger {

    private val messageTimestamps = hashMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        // Verifica se o timestamp é negativo ou se a mensagem é vazia
        if (timestamp < 0 || message.isEmpty()) {
            return false
        }

        // Verifica se a mensagem já foi registrada no hashmap
        val nextAllowedTimestamp = messageTimestamps[message]

        // Se a mensagem não estiver no hashmap ou se o timestamp atual for permitido, atualiza o hashmap
        return if (nextAllowedTimestamp == null || timestamp >= nextAllowedTimestamp) {
            messageTimestamps[message] = timestamp + 10
            true
        } else {
            false
        }
    }
}

/**
 * Seu objeto Logger será instanciado e chamado da seguinte forma:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp, message)
 */
