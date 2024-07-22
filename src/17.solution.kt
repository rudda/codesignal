class RandomizedSet() {
    val hasValues = mutableSetOf<Int>()
    val listOfValues = mutableListOf<Int>()
    fun insert(`val`: Int): Boolean {
        return if(hasValues.contains(`val`)){
            false
        } else {
            hasValues.add(`val`)
            listOfValues.add(`val`)
            true
        }
    }

    fun remove(`val`: Int): Boolean {
        return if(hasValues.contains(`val`)){
            hasValues.remove(`val`)
            listOfValues.remove(`val`)
            true
        }else {
            false
        }
     
    }

    fun getRandom(): Int? {
        if( listOfValues.size == 0) {
            return null
        }
       val randomIndex = (0 .. listOfValues.size -1).random()
       return listOfValues[randomIndex]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */