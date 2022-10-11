fun solution(statues: MutableList<Int>): Int {
    
    statues.sort()
    var count = 0
    return if( statues.size >= 1 && statues.size <= 10) { //constraint
        
        for( i in 1 .. statues.size - 1) {
            var diff = (statues.elementAt(i) - statues.elementAt(i-1)) -1
            count =  count.plus(diff)
        }
        
        count
    } else {
        count
    }

}