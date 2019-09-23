package com.company.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int mod(int x, int m) {
        return (x % m + m) % m;
    }

    public static void writeToFileConsole(String res, String path) throws IOException {
        System.out.println(res);
        FileWriter fw = new FileWriter(new File(path));
        fw.write(res);
        fw.close();
    }
}
