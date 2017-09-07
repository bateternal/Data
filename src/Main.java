
import ir.etick.hibernate.BankAccountEntity;
import ir.etick.hibernate.ContactEntity;
import ir.etick.tools.FileWorker;
import ir.etick.model.HashMap;
import ir.etick.model.Map;
import ir.etick.tools.StaticNameStore;
import ir.etick.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;


/**
 * Created by abolfazl on 8/8/2017.
 * yes created.
 */
public class Main {
    private static ArrayList<String> l  = new ArrayList<String>();
    private static Map<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Start();
//        Run();
////        Test();
//        RunCSV();
//        //sqlGetter();
//        Test();y
// ();
        System.out.println(111111111);
        test2();
        System.out.println(1111111);
    }

    private static void test2(){
//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory= cfg.buildSessionFactory();
//        Session session= (Session) factory.openSession();
//        session.beginTransaction();
        System.out.println("Hibernate one to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        ContactEntity contactEntity= new ContactEntity();
        contactEntity.setId(111);
        contactEntity.setFirstName("abolfazl");
        contactEntity.setLastName("taheri");
        contactEntity.setMellicode("0021369917");
        session.save(contactEntity);

        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setId(2);
        bankAccountEntity.setNumberAccount("12345678");

        bankAccountEntity.setContactEntity(contactEntity);
        contactEntity.getBankAccountEntity().add(bankAccountEntity);

        session.save(bankAccountEntity);

        session.getTransaction().commit();
        ;
    }

    private static void Start(){
        Logger logger = Logger.getLogger(Main.class);
        Properties prop = new Properties();
        InputStream input;
        URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        //String locationi = Main.class.getResource("").getPath();
        try {
            input = new FileInputStream(location.getFile()+"../../../src/resources/particulars.properties");
            prop.load(input);
            StaticNameStore.setFORMAT(prop.getProperty("Formatfile"));
            StaticNameStore.setNameFile(prop.getProperty("Namefile"));
            logger.info("static variables stored!");
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void Run() throws IOException {
        String line = null;
        String cvsSplitBy = ",";
        BufferedReader br = null;
        try {
            URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
            String path = location.getFile();
            br = new BufferedReader(new FileReader(path+"../../../users.csv"));
            String[] country;
            while((line = br.readLine()) != null){
                // use comma as separator
                l = new ArrayList<String>();

                country = line.split(cvsSplitBy);

                l.addAll(Arrays.asList(country).subList(0, 6));

                map.put(country[2],l);
                map.put(country[3],l);
                map.put(country[5],l);


            }
            logger.info("file reading is succesfully");
        } catch (IOException e) {logger.error(e);}
        catch (NullPointerException e){logger.error(e);}
        if (br != null) {br.close();}
    }
/*
    private static void sqlGetter() throws SQLException, ClassNotFoundException {
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/bank";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "09127782297");
        String query = "select * from contact";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);


        ResultSet rst;

        while (rs.next())
        {
            String name = rs.getString("name");
            String lastName = rs.getString("lastname");
            String mellicode = rs.getString("mellicode");
            int id = rs.getInt("id");
            query = "select * from bankaccount where ContactID="+id+"";
            rst = st.executeQuery(query);
            String NumberAccount = rst.getString("NumberAccount");
            id = rst.getInt("id");
            query = "select * from card where BankID="+id+"";
            rst = st.executeQuery(query);
            String amount = rst.getString("amount");
            String cardnumber = rst.getString("cardnumber");


            // print the results


            l = new ArrayList<String>();
            l.add(name);
            l.add(lastName);
            l.add(mellicode);
            l.add(NumberAccount);
            l.add(amount);
            l.add(cardnumber);

            //l.addAll(Arrays.asList(country).subList(0, 6));


            map.put(mellicode,l);
            map.put(NumberAccount,l);
            map.put(cardnumber,l);

        }
        st.close();
    }
    */

    private static void Test(){
        System.out.println(map.get("71528665"));
    }

    private static void RunCSV() throws SQLException, ClassNotFoundException {
        FileWorker csv = new FileWorker();
        csv.Write();
    }
}





