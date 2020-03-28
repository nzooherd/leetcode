func search(nums []int, target int) int {
    var left, right int = 0, len(nums) - 1
    var medium int = (left + right) / 2
    for left <= right {
        medium = (left + right) / 2
        if(nums[medium] > target) {
            right = medium - 1
        } else if(nums[medium] < target) {
            left = medium + 1
        } else {
            return medium
        }
    }
    return -1
}