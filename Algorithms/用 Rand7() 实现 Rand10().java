/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int x = 41;
        while(x > 40){
            x = rand7() + (rand7() - 1) * 7;
        }
        return x % 10 + 1;
    }
}