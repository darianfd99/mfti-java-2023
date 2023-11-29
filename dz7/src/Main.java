public class Main extends Thread{
    public static int sharedValue = 0;
    private static ReadWriteLock rwLock = new ReadWriteLock();
    public static void main(String[] args) {
        Main thread1 = new Main();
        Main thread2 = new Main();
        Main thread3 = new Main();
        Main thread4 = new Main();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void run() {
        try {
            rwLock.acquireWriteLock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ++sharedValue;
        rwLock.releaseWriteLock();

        try {
            rwLock.acquireReadLock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sharedValue);
        rwLock.releaseReadLock();
    }
}