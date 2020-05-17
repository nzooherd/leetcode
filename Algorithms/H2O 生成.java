import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore semaphoreH = new Semaphore(2);
    private Semaphore semaphoreO = new Semaphore(1);
    private Semaphore lockH = new Semaphore(1);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire();
        while(semaphoreH.availablePermits() != 0) ;

            releaseOxygen.run();
            semaphoreH.release();
            semaphoreH.release(); 
            semaphoreO.release();
    }
}