import java.util.Map;
import java.util.WeakHashMap;

class WeakHashMapDemo{


    private static Map map;
    public static void main(String[] arg){
        
            map = new WeakHashMap<>();
            map.put("R28031","Bhavin");
            Runnable runner = new Runnable(){
                public void run()
                {
                    while(map.containsKey("R28031")){
                        try{
                            Thread.sleep(3000);

                        }catch(InterruptedException e){

                        }
                        System.out.println("Thread waiting");
                        System.gc();
                    }
                }
            };
            Thread t = new Thread(runner);
            t.start();
            System.out.println("Main Thread");
            try{
                    t.join();
            }
            catch(InterruptedException e){

            }
    }   
}