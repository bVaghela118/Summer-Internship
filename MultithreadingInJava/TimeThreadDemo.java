import java.util.*;
class TimeThreadDemo {

    Thread t;
    TimeThreadDemo(String nm)
    {
        t= new Thread(new Task(),nm);
        t.start();
    }

    public static void main(String args[])
    {
        TimeThreadDemo ttd = new TimeThreadDemo("'Digital Clock'");
    }

    class Task implements Runnable
    {
        Calendar c;
        Date d;
        public void run()
        {
            for(int i=0;i<10;i++)
            {
                try{
                    c = Calendar.getInstance();
                    d = c.getTime();
                    System.out.println(d);
                    Thread.sleep(1000);
                }
                catch(Exception e){
                    
                }
            }
        }
    }
}
