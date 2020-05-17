import java.util.concurrent.Semaphore;


class FizzBuzz {
    private int value = 1;
    private int n;

    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphore3 = new Semaphore(0);
    private Semaphore semaphore5 = new Semaphore(0);
    private Semaphore semaphore35 = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(value <= n){
            semaphore3.acquire();
                        if(value > n){
                break;
            }
            printFizz.run();
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(value <= n){
            semaphore5.acquire();
if(value > n){
                break;
            }
            printBuzz.run();
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(value <= n){
            semaphore35.acquire();
            if(value > n){
                break;
            }
            printFizzBuzz.run();
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(value <= n){
            semaphore.acquire();
            if (value % 3 == 0 && value % 5 == 0){
                semaphore35.release();
            }else if(value % 3 == 0){
                semaphore3.release();
            }else if(value % 5 == 0){
                semaphore5.release();
            } else{
                printNumber.accept(value);
                semaphore.release();
            }
            value++;
        }
        semaphore5.release();
        semaphore35.release();
        semaphore3.release();
    }
}