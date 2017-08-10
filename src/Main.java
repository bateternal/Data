import DataStructure.HashMap;
import DataStructure.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import java.io.*;
import java.util.ArrayList;


/**
 * Created by abolfazl on 8/8/2017.
 */
public class Main {
    private static ArrayList<String> l = new ArrayList<String>();
    private static Map<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    final static Logger logger = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) throws IOException {
        Run();
    }

    private static void Run() throws IOException {
        PropertyConfigurator.configure("src\\resources\\log4j.properties");
        String line;
        String cvsSplitBy = ",";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\abolfazl\\Desktop1\\a.csv"));
            logger.info("file reading is succesfully");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        try {
            while((line = br.readLine()) != null){
                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                for (int i = 0; i < 6; i++) {l.add(country[i]);} //create list of variables

                map.put(country[2],l);
                map.put(country[3],l);
                map.put(country[5],l);

            }
        } catch (IOException e) {
            logger.error(e);
        }
        br.close();
    }





    }





