package lol.kek;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi Mark!");

        ArrayList<String> lil = FileWork.readFile("D:\\kek\\small-test.in.txt");
        for (String s : lil)
            System.out.println(s);
        ArrayList<String[]> kik = FileWork.transform(lil);
        for (String[] s : kik)
            System.out.println(Arrays.toString(s));
    }


}
