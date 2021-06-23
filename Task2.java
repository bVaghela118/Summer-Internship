import java.net.URI;
import java.sql.*;
import java.util.*;
//C:\Program Files\AdoptOpenJDK\jdk-15.0.1.9-openj9\bin

public class Task2 {

    private static Scanner in = new Scanner(System.in);

    public static Scanner getScanner() {
        return in;
    }

    public static void DatabaseConnect() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papergenerator", "root", "");
            Statement stmnt = conn.createStatement();
            Scanner in = getScanner();
            System.out.println("How many Entry you want to insert:");
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("ID:");
                int id = in.nextInt();
                System.out.println("Name :");
                String name = in.next();
                System.out.println("Password :");
                String pass = in.next();
                System.out.println("Gmail:");
                String mail = in.next();
                System.out.println("Contact:");
                long phone = in.nextLong();
                String qry = "Insert INTO user VALUES(" + id + ",'" + name + "','" + pass + "','" + mail + "'," + phone
                        + ");";
                System.out.println(qry);
                stmnt.executeUpdate(qry);

            }
            System.out.println(n + " Rows Inserted Succesfully!");
            // ResultSet rs = stmnt.executeQuery("Select userid from user");
            // while (rs.next()) {
            // System.out.println("User " + rs.getInt("userid"));
            // }
        } catch (Exception e) {
            System.out.println("Not Connected!" + e.getMessage());
        }
    }

    public static void ModuleEntry() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papergenerator", "root", "");
            Statement stmnt = conn.createStatement();
            System.out.println("How many Entry you want to insert:");
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("Module ID:");
                int mID = in.nextInt();
                in.nextLine();
                System.out.println("Name :");
                String name = in.nextLine();
                System.out.println("User ID:");
                int uID = in.nextInt();
                String sql = "Insert INTO module values(" + mID + ",'" + name + "'," + uID + ")";
                System.out.println(sql);
                stmnt.executeUpdate(sql);
                System.out.println("Inserted Succesfully!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class Data {
        int id;
        String name;
        String mail;
        long contact;

        Data(int id, String name, String mail, long contact) {
            this.id = id;
            this.name = name;
            this.mail = mail;
            this.contact = contact;
        }
    }

    public static class Thread1 implements Runnable {
        Thread1() {
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            List<Data> lst = new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papergenerator", "root", "");
                Statement stmnt = conn.createStatement();
                String sql = "Select userid,userName,email,contactNo from user;";
                ResultSet rs = stmnt.executeQuery(sql);
                long start = 0, end = 0;
                start = System.currentTimeMillis();
                while (rs.next()) {
                    lst.add(new Data(rs.getInt("userid"), rs.getString("userName"), rs.getString("email"),
                            rs.getLong("contactNo")));
                    System.out.println("ID: " + rs.getInt("userid") + " Name: " + rs.getString("userName") + " Email: "
                            + rs.getString("email") + " Contact No: " + rs.getLong("contactNo"));
                    Thread.sleep(1500);
                }
                end = System.currentTimeMillis();
                System.out.println("Time taken for execution serial: " + (end - start));
                // start = 0;
                // end = 0;
                // start = System.currentTimeMillis();
                // lst.parallelStream()
                // .forEach(e -> System.out.println(e.id + " " + e.name + " " + e.mail + " " +
                // e.contact));
                // Thread.sleep(1500);
                // end = System.currentTimeMillis();
                // System.out.println("Time taken for execution Parallel: " + (end - start));
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Not run");
            }
        }
    }

    public static class Thread2 implements Runnable {
        Thread2() {
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papergenerator", "root", "");
                Statement stmnt = conn.createStatement();
                String sql = "Select moduleid,name,user_userid from module;";
                ResultSet rs = stmnt.executeQuery(sql);
                long start = 0, end = 0;
                start = System.currentTimeMillis();
                while (rs.next()) {
                    System.out.println("ModuleID: " + rs.getInt("moduleid") + " Module Name: " + rs.getString("name")
                            + " User Id: " + rs.getInt("user_userid"));
                    Thread.sleep(1000);
                }
                end = System.currentTimeMillis();
                System.out.println("Time taken for execution: " + (end - start));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String args[]) throws Exception {
        // DatabaseConnect();
        // ModuleEntry();
        long start = 0, end = 0;
        start = System.currentTimeMillis();
        new Thread1();
        // t1.start();
        end = System.currentTimeMillis();
        System.out.println("Time taken for execution of Thread: " + (end - start));

        start = System.currentTimeMillis();
        new Thread2();
        // t2.start();
        end = System.currentTimeMillis();
        System.out.println("Time taken for execution of Thread: " + (end - start));
        in.close();

    }
}