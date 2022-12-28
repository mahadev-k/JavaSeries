package multithreading;

public class ThreadA extends Thread{
    BookingService bookingService;

    public ThreadA(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @Override
    public void run(){
        boolean booked = false;
        try {
            booked = bookingService.book();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName()+ " booked : "+ booked);
    }
}
