package ir.etick.tool;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by abolfazl on 8/12/2017.
 */
public class NameStore {
    private  String NAME_FILE;
    private String FORMAT;
    private Properties prop;
    private InputStream input;

    public NameStore() {
        Logger logger = Logger.getLogger(NameStore.class);
        try {
            fileReader();
        } catch (IOException e) {
            logger.error(e);
        }
        NAME_FILE = prop.getProperty("Namefile");
        FORMAT = prop.getProperty("Formatfile");
    }

    public void fileReader() throws IOException {
        prop = new Properties();
        input = new FileInputStream("D:\\java\\HelloPerformance\\src\\resources\\particulars.properties");
        prop.load(input);
    }

    public String getNAME_FILE() {
        return NAME_FILE;
    }



    public String getFORMAT() {
        return FORMAT;
    }

}
