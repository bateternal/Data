import ir.etick.tool.FileWorker;
import ir.etick.model.HashMap;
import ir.etick.model.Map;
import ir.etick.tool.StaticNameStore;
import ir.etick.tool.StaticNameStorei;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;


/**
 * Created by abolfazl on 8/8/2017.
 * yes created.
 */
public class Main {
    private static ArrayList<String> l  = new ArrayList<String>();
    private static Map<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Start();
        Run();
//        Test();
        RunCSV();
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

    private static void Test(){
        System.out.println(map.get("11111139"));
    }

    private static void RunCSV(){
        FileWorker csv = new FileWorker();
        csv.Write();
    }
}





