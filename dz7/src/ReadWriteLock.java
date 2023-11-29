public class ReadWriteLock {
    static final int WRITE_LOCKED = -1, FREE = 0;

    private int numberOfReaders = FREE;
    private Thread currentWriteLockOwner = null;

    public synchronized void acquireReadLock() throws InterruptedException {
        if (numberOfReaders == WRITE_LOCKED) this.wait();
        ++numberOfReaders;
    }

    public synchronized void releaseReadLock(){
        if (numberOfReaders <= FREE) throw new IllegalMonitorStateException();
        --numberOfReaders;
        if (numberOfReaders == FREE) this.notifyAll();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while(numberOfReaders != FREE) this.wait();
        numberOfReaders = WRITE_LOCKED;
        currentWriteLockOwner = Thread.currentThread();
    }

    public synchronized void releaseWriteLock(){
        if (numberOfReaders != WRITE_LOCKED || currentWriteLockOwner != Thread.currentThread()) throw new IllegalMonitorStateException();
        numberOfReaders = FREE;
        currentWriteLockOwner = null;
        this.notifyAll();
    }
}
