package lol.kek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileWork {

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> res = new ArrayList<>();
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }

    public static ArrayList<String[]> transform(ArrayList<String> strings) {
        ArrayList<String[]> res = new ArrayList<>();
        for (int i = 1; i < Integer.parseInt(strings.get(0)); i++)
            res.add(strings.get(i).split(" "));
        return res;
    }

}
