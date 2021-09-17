class ParkingSystem(private var big: Int, private var medium: Int, private var small: Int) {

    fun addCar(carType: Int): Boolean = 
        when(carType) {
            1 -> (big--).let { big >= 0 }
            2 -> (medium--).let { medium >= 0 }
            3 -> (small--).let { small >= 0 }
            else -> false
        }
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */