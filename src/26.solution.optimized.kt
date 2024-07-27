class Solution {
    fun maxProfit(prices: IntArray): Int {
        // brutal for 
        // for each element in the array can be a day for by
        // I can buy in the firt day -> 7
        // I can sell in the second day -> 1
        // the profit is = -6
        // buy in 1st       [-6, -2, -4, -1, -3 ]
        // buy in the 2nd   [+4, +2, +5, +3]
        // buy in the 3th   [-2, -1, -1]
        // buy in the 4td.  [-3, +1]
        // buy in the 5th   [-2]


        // optimized way
        // prices = [7,1,5,3,6,4]
        // profit = 0 -> 4 -> 5
        // buy =  7, 1
        // sell = 1, 5, 3,4
        // math = (sell- buy) -> (5-1) -> 4
        // profit = max(buy - sell, profit)
      


        var maxProfit = 0
        var bPrice= prices[0]

        for(  i in 1 until prices.size) {
            if( bPrice > prices[i]) {
                bPrice = prices[i]
            }

            maxProfit = maxOf(maxProfit,  prices[i] - bPrice )
        }

        return maxProfit
    }
}
// input
// prices[]
// prices[7,1,5,3,6,4]
// 7 -> 1st day
// 1 -> 2nd day ...
// I must to choose 2 day
// 1st is to buy and 2nd is to sell
// goal is get more profit in this operation
// return maximun of the profit
// default return 0


