package ir.etick.tool;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by abolfazl on 8/12/2017.
 *
 */
public class StaticNameStorei {
    private static String NAME_FILE;
    private static String FORMAT;
    private static Properties prop;
    private static InputStream input;

    private StaticNameStorei() {
        Logger logger = Logger.getLogger(StaticNameStorei.class);
        try {
            fileReader();
        } catch (IOException e) {
            logger.error(e);
        }
        NAME_FILE = prop.getProperty("Namefile");
        FORMAT = prop.getProperty("Formatfile");
    }

    public static void fileReader() throws IOException {
        prop = new Properties();
        input = new FileInputStream("D:\\java\\HelloPerformance\\src\\resources\\particulars.properties");
        prop.load(input);
    }

    public static String getNAME_FILE() {
        return NAME_FILE;
    }



    public static String getFORMAT() {
        return FORMAT;
    }

}
