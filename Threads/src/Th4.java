// Author: Johanna Guevara
// Project Description:
// Fix and explain program faults.

public class Th4 {
    static DemoThread t1;
    static DemoThread t2;
    static Object     lock;
    static class DemoThread extends Thread {
        long t1, t2;
        boolean waitthread;

        public DemoThread(long a, long b, boolean w) {
            t1 = a;t2 = b;
        }

        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": running ...");
            try {
                Thread.sleep(t1);
            } catch (InterruptedException e) {
                System.out.println(name + ": interrupted");
            }
            System.out.println(name + ": after t1 sleep, t1 = " + t1);

            if (waitthread) {
                System.out.println(name + ": waiting...");
                synchronized(lock) {
                    try {
                        lock.wait();
                    }
                    { }
                }
            }
            else {
                System.out.println(name + ": notifying...");
                synchronized(lock) {
                    lock.notify();
                }
            }

            System.out.println(name + ": after wait/notify");
        }
    }

    public static void main(String[] args) {
        lock = new Object();
        t1 = new DemoThread(3000,true);
        t2 = new DemoThread(6000,false);
        t1.start();
        t2.start();
    }
}