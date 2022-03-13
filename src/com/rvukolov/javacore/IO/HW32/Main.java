package com.rvukolov.javacore.IO.HW32;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static File SAVE_DIR = new File("C:" + File.separator + "Games" + File.separator
            + "savegames");
    public static final String saveFileMask = "[a-z]+[0-9]+.dat";

    public static void main(String[] args) {
        GameProgress gameProgressFirst = new GameProgress(80, 1, 5, 544);
        GameProgress gameProgressSecond = new GameProgress(5, 0, 34, 59);
        GameProgress gameProgressThird = new GameProgress(97, 15, 48, 152);
        Saver saver = new Saver();

        try {
            saver.saveGameState(gameProgressFirst);
            saver.saveGameState(gameProgressSecond);
            saver.saveGameState(gameProgressThird);
        } catch (Exception e) {
            e.getMessage();
        }

        saver.clearDatFiles();
    }
}
