func lemonadeChange(bills []int) bool {
    var count5, count10 int
    for _, bill := range bills {
        if(bill == 5){
            count5++
        } else if(bill == 10){
            count5--
            count10++
        } else if(bill == 20) {
            if(count10 >= 1) {
                count10--;
                count5--;
            } else {
                count5 -= 3;
            }
        }
        if(count5 < 0){
            return false
        }
    }
    return true
    
}