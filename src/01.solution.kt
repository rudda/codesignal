fun solution(year: Int): Int {
  return if(year <= 2005 && year >= 1) {
       return if (year % 100 == 0 ) {
        (year / 100) 
       } else {
           (year / 100) + 1
       }
  } else {
      0
  }
}
