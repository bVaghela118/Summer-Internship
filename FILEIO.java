import java.io.*;
import java.util.*;

class FILEIO {
    // private static Scanner in = new Scanner(System.in);
    public static List<student> students = new ArrayList<>();

    // public static Scanner getScanner() {
    // return in;
    // }

    public static class student {
        int id;
        float cpi;
        String nm;

        student() {

        }

        student(int id, float cpi, String nm) {
            this.id = id;
            this.nm = nm;
            this.cpi = cpi;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return nm;
        }

        public float getCPI() {
            return cpi;
        }

        final void Display() {
            System.out.println(id + " " + cpi + " " + nm);
            // return true;
        }
    }

    public static void fileReading() {
        try {
            Scanner in = new Scanner(new File("B:/MSC(IT)/Sem2/IT602 OOPS/Assignment6/Student.txt"));
            while (in.hasNext()) {
                int ids = in.nextInt();
                float cpi = in.nextFloat();
                String nm = in.nextLine();
                students.add(new student(ids, cpi, nm));
            }
            long start = 0, end = 0;
            start = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                students.parallelStream().forEach(e -> System.out.println(e.id + "|\t|" + e.cpi + "|\t|" + e.nm));
            }
            end = System.currentTimeMillis();
            System.out.println("Time taken for execution serial: " + (end - start));
        } catch (IOException e) {
            e.getMessage();

        }
    }

    static void findFromFile() {

    }

    public static void main(String[] args) throws IOException {
        fileReading();
        findFromFile();
        // in.close();
    }
}