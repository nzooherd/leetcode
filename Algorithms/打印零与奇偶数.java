import java.util.concurrent.Semaphore;
class ZeroEvenOdd {
    public static class WrapInteger{
        public int value;
        public WrapInteger(){
            this.value = 0;
        }
    }

    private int n;
    private WrapInteger wrapInteger = new WrapInteger();
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(0);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
            while(wrapInteger.value <= n){
                semaphore.acquire();
                if(wrapInteger.value >= n) {
                    semaphoreOdd.release();
                    semaphoreEven.release();
                    break;
                }
                printNumber.accept(0);
                if(wrapInteger.value % 2 == 0){
                    semaphoreOdd.release();
                } else{
                    semaphoreEven.release();
                }
            }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
            while(wrapInteger.value < n){
                semaphoreEven.acquire();
                if(wrapInteger.value >= n) break;
                wrapInteger.value += 1;
                printNumber.accept(wrapInteger.value);
                semaphore.release();
            }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
            while(wrapInteger.value < n){
                semaphoreOdd.acquire();
                if(wrapInteger.value >= n) break;
                wrapInteger.value += 1;
                printNumber.accept(wrapInteger.value);
                semaphore.release();
            }
    }
}