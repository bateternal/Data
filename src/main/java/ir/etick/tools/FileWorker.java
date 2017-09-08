package ir.etick.tools;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * Created by abolfazl on 8/12/2017.
 * *
 */
public class FileWorker {
    private Random random = new Random();
    private Set<Integer> set = new HashSet<Integer>();
    private Set<String> seti = new HashSet<String>();


    public void Write() throws SQLException, ClassNotFoundException {
        Logger logger = Logger.getLogger(FileWorker.class);
        try {
            stringAppender();
            logger.info("CSV file created!");
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }

    }


    private String setOctet(int number){
        int a;
        Random r = new Random();
        String s = String.valueOf(number);
        while (s.length() < 8){
            a = r.nextInt(9);
            s = s + String.valueOf(a);
        }
        if(seti.contains(s)) return setOctet(r.nextInt(100000000));
        else {
            seti.add(s);
            return s;
        }
    }

    private String setTen(int number){
        int a;
        Random r = new Random();
        String s = String.valueOf(number);
        while (s.length() < 10){
            a = r.nextInt(9);
            s = s + String.valueOf(a);
        }
        if(seti.contains(s)) return setTen(r.nextInt(100000000));
        else {
            seti.add(s);
            return s;
        }
    }

    private String setSixteen(int number){
        int a;
        Random r = new Random();
        String s = String.valueOf(number);
        while (s.length() < 16){
            a = r.nextInt(9);
            s = s + String.valueOf(a);
        }
        if(seti.contains(s)) return setSixteen(r.nextInt(1000000));
        else {
            seti.add(s);
            return s;
        }
    }

    private void stringAppender() throws IOException, SQLException, ClassNotFoundException {
        int lim;
        set.clear();
        System.out.println(set);

        PrintWriter pw = new PrintWriter(new File("src/main/java/users.csv"));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);

                lim = random.nextInt(100000) ;
                while (set.contains(lim)){
                    lim = random.nextInt(100000);
                }
                set.add(lim);
                StringBuilder name = new StringBuilder();
                name.append("abolfazl").append(String.valueOf(i));
                sb.append(name);
                sb.append(',');
                sb.append("taheri").append(String.valueOf(i));
                sb.append(',');
                sb.append(setTen(lim));
                sb.append(',');
                sb.append(setOctet(lim));
                sb.append(',');
                sb.append(String.valueOf(lim));
                sb.append(',');
                sb.append(setSixteen(lim));
                sb.append('\n');

            }
        pw.write(sb.toString());
        pw.close();




        // execute the java preparedstatement
        //preparedStmt.executeUpdate();


    }


}
