package ir.etick.tool;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by abolfazl on 8/13/2017.
 */
public class StaticNameStore {
    private static String NAME_FILE;
    private static String FORMAT;

    private static StaticNameStore ourInstance = new StaticNameStore();

    public static StaticNameStore getInstance() {
        return ourInstance;
    }

    private StaticNameStore() {
    }

    //////// getter /////////

    public static String getNameFile() {
        return NAME_FILE;
    }

    public static String getFORMAT() {
        return FORMAT;
    }

    ///////// setter /////////

    public static void setNameFile(String nameFile) {
        NAME_FILE = nameFile;
    }

    public static void setFORMAT(String FORMAT) {
        StaticNameStore.FORMAT = FORMAT;
    }


}
