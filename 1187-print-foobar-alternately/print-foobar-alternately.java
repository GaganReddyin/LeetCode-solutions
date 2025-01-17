class FooBar {
    private int n;

    Semaphore s1;

    Phaser p;

    public FooBar(int n) {
        this.n = n;
        s1 = new Semaphore(0);
        p = new Phaser(2);

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            s1.release();
            p.arriveAndAwaitAdvance();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            s1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            p.arriveAndAwaitAdvance();
        }
    }
}