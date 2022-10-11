fun solution(inputArray: MutableList<Int>): Int {
  var should_return = 0
  val size = inputArray.size - 1
 
  
  for(i in 0.. size-1) {
     
        var product = inputArray.elementAt(i) * inputArray.elementAt(i+1) 
        print("(${inputArray.elementAt(i)}, ${inputArray.elementAt(i+1)}) = $product ")
        should_return = if(product > should_return || i == 0) product else should_return
        print("${should_return}")
          
  }
  return should_return
}