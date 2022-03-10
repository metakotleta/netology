package com.rvukolov.javacore.IO.HW31;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Files example = new Files();

        File gamesSrc = example.makeDir("C:\\Games", "src");
        File gamesRes = example.makeDir("C:\\Games", "res");
        File gamesSaveGames = example.makeDir("C:\\Games", "savegames");
        File gamesTemp = example.makeDir("C:\\Games", "temp");

        File gamesSrcMain = example.makeDir(gamesSrc, "main");
        File gamesSrcTest = example.makeDir(gamesSrc, "test");

        File gamesResDrawables = example.makeDir(gamesRes, "drawables");
        File gamesResVectors = example.makeDir(gamesRes, "vectors");
        File gamesResIcons = example.makeDir(gamesRes, "icons");
        File tempLogTxt = example.makeFile(gamesTemp, "log.txt");

        File mainMainJava = example.makeFile(gamesSrcMain, "Main.java");
        File mainUtilsJava = example.makeFile(gamesSrcMain, "Utils.java");

        example.writeLogFile(tempLogTxt);
    }
}
