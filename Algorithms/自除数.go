func selfDividingNumbers(left int, right int) []int {
    var ret []int;
    for i := left; i <= right; i++ {
        if judgeNumber(i) {
            ret = append(ret, i);
        }
    }
    return ret;
}
func judgeNumber(num int) bool {
    var ret bool = false;
    var temp int = num;
    for temp > 0 {
        if (temp % 10 == 0) ||(num % (temp % 10) != 0) {
            return ret;
        }
        temp /= 10;
    }
    ret = true;
    return ret;
}