class Bank(balance: LongArray) {
    private val accounts = mutableMapOf<Int, Long>()
    init {
        for (i in 1..balance.size) {
            accounts[i] = balance[i-1]
        }
    }


    fun transfer(account1: Int, account2: Int, money: Long): Boolean {
        if (!isValidCount(account1)) {
            return false
        }
        if (!isValidCount(account2)) {
            return false
        }
        if (accounts[account1]!! < money) {
            return false
        }
        accounts[account1] = accounts[account1]!! - money
        accounts[account2] = accounts[account2]!! + money
        return true
    }

    fun deposit(account: Int, money: Long): Boolean {
        if (!isValidCount(account)) {
            return false
        }
        accounts[account] = accounts[account]!! + money
        return true
    }

    fun withdraw(account: Int, money: Long): Boolean {
        if (!isValidCount(account)) {
            return false
        }
        if (accounts[account]!! < money) {
            return false
        }
        accounts[account] = accounts[account]!! - money
        return true
    }

    private fun isValidCount(account: Int): Boolean {
        if (account >= 1 && account <= accounts.size) {
            return true
        }
        return false
    }

}

/**
 * Your Bank object will be instantiated and called as such:
 * var obj = Bank(balance)
 * var param_1 = obj.transfer(account1,account2,money)
 * var param_2 = obj.deposit(account,money)
 * var param_3 = obj.withdraw(account,money)
 */