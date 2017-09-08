
import ir.etick.hibernate.BankAccountEntity;
import ir.etick.hibernate.CardEntity;
import ir.etick.hibernate.ContactEntity;
import ir.etick.hibernate.TransactionEntity;
import ir.etick.tools.FileWorker;
import ir.etick.model.HashMap;
import ir.etick.model.Map;
import ir.etick.tools.StaticNameStore;
import ir.etick.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;


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
    private static ContactEntity contactEntity;
    private static BankAccountEntity bankAccountEntity;
    private static CardEntity cardEntity;
    private static TransactionEntity transactionEntity ;
    private static Session session;

    private static String csvFile;
    private static String line = "";
    private static String cvsSplitBy = ",";
    private static BufferedReader br;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Start();
//        Run();
////        Test();
 //       RunCSV();
//        //sqlGetter();
//        Test();y
// ();

       test2();

    }

    private static void test2(){

        System.out.println("Hibernate one to many (Annotation)");
        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        /*///

        *code here
        *
        *

        *////



        try  {
            int i=0;
            while ((line = br.readLine()) != null) {
                i++;
                // use comma as separator
                System.out.println(line);
                String[] contact = line.split(",");

                Create_Contact(contact[0],contact[1],contact[2]);
                System.out.println(contact[3]);
                Create_BankAccount(contact[3]);
                System.out.println(contact[4]);
                System.out.println(i);
                Create_Card(Integer.parseInt(contact[4]),contact[5]);


            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();

        try {
            HibernateUtil.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Create_Contact(String first_name,String last_name,String melli_code){
        contactEntity= new ContactEntity();

        contactEntity.setFirstName(first_name);
        contactEntity.setLastName(last_name);
        contactEntity.setMellicode(melli_code);
        session.save(contactEntity);
    }

    private static void Create_BankAccount(String number_account){
        bankAccountEntity = new BankAccountEntity();
        bankAccountEntity.setNumberAccount(number_account);

        bankAccountEntity.setContactEntity(contactEntity);
        contactEntity.getBankAccountEntity().add(bankAccountEntity);

        session.save(bankAccountEntity);
    }

    private static void Create_Card(int amonut, String card_number){
        cardEntity = new CardEntity();
        cardEntity.setAmount(amonut);
        cardEntity.setCardNumber(card_number);

        cardEntity.setBankAccountEntity(bankAccountEntity);
        bankAccountEntity.getCardEntity().add(cardEntity);

        session.save(cardEntity);
    }

    private static void Create_Transaction(int number_amount,String destination_numberaccount){
        transactionEntity = new TransactionEntity();
        transactionEntity.setNumberAmount(number_amount);
        transactionEntity.setDestination_numberaccount(destination_numberaccount);

        transactionEntity.setBankAccountEntity(bankAccountEntity);
        bankAccountEntity.getTransactionEntity().add(transactionEntity);

        session.save(transactionEntity);
    }

    private static void Start(){
        br = null;
        try {
            URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
            String path = location.getFile();
            br = new BufferedReader(new FileReader(path + "users.csv"));
        }
        catch (Exception e){}
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

    private static void Read_Data() throws IOException {
        String line = null;
        String cvsSplitBy = ",";

        try {

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





