import DataStructure.HashMap;
import DataStructure.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.*;
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
    private final static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws IOException {
        Run();
        Test();
    }

    private static void Run() throws IOException {
        Properties prop = new Properties();
        String path = "D:\\java\\HelloPerformance\\src\\resources\\log4j.properties";
        InputStream input = new FileInputStream(path);
        prop.load(input);
        PropertyConfigurator.configure(path);
        String line = null;
        String cvsSplitBy = ",";
        BufferedReader br = null;
        try {
            path = prop.getProperty("Path");
            br = new BufferedReader(new FileReader(path));
            String[] country;
            while((line = br.readLine()) != null){
                System.out.println(line);
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
}





