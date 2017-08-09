import DataStructure.HashMap;
import DataStructure.HashMapLink;
import DataStructure.Map;
import DataStructure.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abolfazl on 8/8/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        Map<String, Integer> myMap = new HashMapLink<String,Integer>();
//
//        for(int i = 0; i < 1000; i += 2)
//        {
//            String s = "#" + i;
//            myMap.put(s, i);
//        }
//        System.out.println("Size: " + myMap.size());
//        for(int i = 0; i < 1000; ++i)
//        {
//            String s = "#" + i;
//            Integer value = myMap.get(s);
//            System.out.println("Key: " + s + " Value: " + value);
//        }
        Map<String,ArrayList<String>> m = new HashMap<String, ArrayList<String>>();

        /////////////

        String line = null;
        String cvsSplitBy = ",";
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\abolfazl\\Desktop\\a.csv"));
        while((line = br.readLine()) != null){
            String[] b = line.split(splitBy);
            ArrayList<String> l = new ArrayList<String>();
             ;
            // use comma as separator
            String[] country = line.split(cvsSplitBy);
            l.add(country[0]);
            l.add(country[1]);
            l.add(country[2]);
            l.add(country[3]);
            l.add(country[4]);
            l.add(country[5]);
            m.put(country[2],l);
            m.put(country[3],l);
            m.put(country[5],l);

        }
        br.close();
        System.out.println(m.get("abolfazl1"));
    }

        /////////////
//        String csvFile = "C:\Users\abolfazl\Desktop\a.csv";
//        BufferedReader br = null;
//        String line = "";
//        String cvsSplitBy = ",";
//
//        try {
//
//            br = new BufferedReader(new FileReader(csvFile));
//            while ((line = br.readLine()) != null) {
//                List<String> l = null;
//                // use comma as separator
//                String[] country = line.split(cvsSplitBy);
//                l.add(country[1]);
//                l.add(country[2]);
//                l.add(country[3]);
//                l.add(country[4]);
//                l.add(country[5]);
//                m.put(country[0],l);
//
//
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        ///////////////

//        m.get("abolfazl1");


    }





