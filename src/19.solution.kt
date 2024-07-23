class Logger() {
    private val mapper = hashMapOf<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
      // case 1: [] -> return null
      // edge case 1: can I have a negative timestamp ? 
      // edge case 2: can I have a empty or null message string ?
      if(timestamp < 0 || message.isEmpty()) {
        return false
      }
       
      // store the values and uptade
      // hasmap where the key is the message and the value is the next allowed timestamp
      return if(mapper.containsKey(message)) {
        println("containsKey: $message")
        val allowedTimestamp = mapper.get(message)
        return if( timestamp >= allowedTimestamp!!) {
            println("the timestamp $timestamp >=  $allowedTimestamp")
            mapper.put(message, timestamp.plus(10))
            true
        } else {
            println("the timestamp $timestamp is not allowed to  $allowedTimestamp")
            false
        }
      } else {
        println("adding and return true")
         mapper.put(message, timestamp.plus(10))
         true
      }  

    }

}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */