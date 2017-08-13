package ir.etick.tool;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
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


    public void Write(){
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
        if(seti.contains(s)) return setOctet(r.nextInt(10000));
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
        if(seti.contains(s)) return setTen(r.nextInt(10000));
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
        if(seti.contains(s)) return setSixteen(r.nextInt(10000));
        else {
            seti.add(s);
            return s;
        }
    }

    private void stringAppender() throws IOException {
        int lim;
        String FORMAT = StaticNameStore.getFORMAT();
        String NAME_FILE = StaticNameStore.getNameFile();

          PrintWriter pw = new PrintWriter(new File(NAME_FILE + FORMAT));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                lim = random.nextInt(100000) ;
                while (set.contains(lim)){
                    lim = random.nextInt(100000);
                }
                set.add(lim);
                sb.append("abolfazl").append(String.valueOf(lim));
                sb.append(',');
                sb.append("taheri").append(String.valueOf(lim));
                sb.append(',');
                sb.append(setTen(lim));
                sb.append(',');
                sb.append(setOctet(lim));
                sb.append(',');
                sb.append(String.valueOf(lim));
                sb.append(',');
                sb.append(setSixteen(lim));
                sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
    }
}
