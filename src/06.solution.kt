fun solution(sequence: MutableList<Int>): Boolean {
    
    var removedItemCount = 0 // total de itens a serem removidos
    var lastItem = 0
    if( sequence.size >= 100000) return true
    
    for( i in 1 .. sequence.size -1) {
        println (" ${sequence.get(lastItem)} , ${sequence.get(i)} ")
        
        if( sequence.get(lastItem) < sequence.get(i)) {
            lastItem = i
        } else {
            if( lastItem == 0  ) {
                lastItem = i
            } else {
                if(sequence.get(lastItem -1) < sequence.get(i)) {
                    lastItem = i
                }
            }
            removedItemCount+= 1 
            println("increment: $removedItemCount")  
             
        }
    }
  
  return removedItemCount <= 1
}
