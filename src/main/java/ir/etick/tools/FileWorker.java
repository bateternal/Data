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
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/etick";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "09127782297");
            StringBuilder sb ;
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
                sb = new StringBuilder();
                lim = random.nextInt(100000) ;
                while (set.contains(lim)){
                    lim = random.nextInt(100000);
                }
                set.add(lim);
                StringBuilder name = new StringBuilder();
                name.append("\'abolfazl").append(String.valueOf(i)).append("\'");
                sb.append(name);
                sb.append(',');
                sb.append("\'taheri").append(String.valueOf(i)).append("\'");
                sb.append(',');
                sb.append("\'").append(setTen(lim)).append("\'");
//                sb.append(',');
//                sb.append("\'").append(setOctet(lim)).append("\'");
//                sb.append(',');
//                sb.append("\'").append(String.valueOf(lim)).append("\'");
//                sb.append(',');
//                sb.append("\'").append(setSixteen(lim)).append("\'");
//                //sb.append('\n');
                int id = 0;
                String query = "insert into contact(first_name,last_name,melli_code) values("+sb.toString()+")";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
                query = "select * from contact where first_name="+name+"";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next()) {
                    id = rs.getInt("id");
                    query = "insert into bank_account(Number_Account,ContactID) values(" + setOctet(lim) + "," + id + ")";
                }
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
                query = "select * from bank_account where ContactID="+id+"";
                st = conn.createStatement();
                rs = st.executeQuery(query);
                while (rs.next()) {
                    id = rs.getInt("id");
                    query = "insert into card(card_number,amount,BankID) values(" + setSixteen(lim) + "," + lim + "," + id + ")";
                }
                preparedStmt = conn.prepareStatement(query);
                preparedStmt.executeUpdate();
            }




        // execute the java preparedstatement
        //preparedStmt.executeUpdate();

        conn.close();
    }


}
