fun differenceOfSum(nums: IntArray): Int {
    var sum=0 //for number sum
    var bitsum = 0 //for digit sum
    for(i in nums){
        sum+=i
        var x=i
        while(x>0){
            bitsum+=(x%10)
            x=x/10
        }
    }
    return Math.abs(bitsum-sum)
}