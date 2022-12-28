package multithreading;

public class ThreadB extends Thread{
    BookingService bookingService;

    public ThreadB(BookingService bookingService){
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
