package ir.etick.tool;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
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
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/test";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "09127782297");
            StringBuilder sb ;
            for (int i = 0; i < 1000; i++) {
                sb = new StringBuilder();
                lim = random.nextInt(100000) ;
                while (set.contains(lim)){
                    lim = random.nextInt(100000);
                }
                set.add(lim);
                sb.append("\'abolfazl").append(String.valueOf(i)).append("\'");
                sb.append(',');
                sb.append("\'taheri").append(String.valueOf(i)).append("\'");
                sb.append(',');
                sb.append("\'").append(setTen(lim)).append("\'");
                sb.append(',');
                sb.append("\'").append(setOctet(lim)).append("\'");
                sb.append(',');
                sb.append("\'").append(String.valueOf(lim)).append("\'");
                sb.append(',');
                sb.append("\'").append(setSixteen(lim)).append("\'");
                //sb.append('\n');
                String s ="1,1,1,1,1,1";
                String query = "insert into userss(name,lastname,mellicode,number,amount,cardnumber) values("+sb.toString()+")";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
            }




        // execute the java preparedstatement
        //preparedStmt.executeUpdate();

        conn.close();
    }


}
