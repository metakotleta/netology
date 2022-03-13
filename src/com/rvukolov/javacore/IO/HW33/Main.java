package com.rvukolov.javacore.IO.HW33;

import java.io.File;

public class Main {
    public static File SAVE_DIR = new File("C:" + File.separator + "Games" + File.separator
            + "savegames");
    public static String ZIP_NAME = "savefiles.zip";

    public static void main(String[] args) {
        Loader loader = new Loader();


        loader.unZip(ZIP_NAME);
        for (int i = 0; i < loader.getFileNames().size(); i++) {
            System.out.println(loader.loadSavedGame(loader.getFileNames().get(i)));
        }
    }
}
