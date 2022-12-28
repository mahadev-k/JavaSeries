package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {

    int totalSeats = 1;

    public synchronized boolean book() throws InterruptedException {
        return bookWithLock();
    }

    public synchronized boolean bookWithSynchronizedKeyword() throws InterruptedException {
       if(totalSeats>0){
           Thread.sleep(10); // Block of code pushing the change to db or some piece of code that executes some logic before booking
           totalSeats--;
           return true;
       }else{
           return false;
       }
    }

    public boolean bookWithSyncBlock() throws InterruptedException {
        synchronized (this) {
            if (totalSeats > 0) {
                Thread.sleep(10); // Block of code pushing the change to db or some piece of code that executes some logic before booking
                totalSeats--;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean bookWithLock() throws InterruptedException{
        boolean isBooked = false;
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            if (totalSeats > 0) {
                Thread.sleep(10); // Block of code pushing the change to db or some piece of code that executes some logic before booking
                totalSeats--;
                isBooked =  true;
            } else {
                isBooked =  false;
            }
        }finally {
            lock.unlock();
        }

        return isBooked;
    }
}
