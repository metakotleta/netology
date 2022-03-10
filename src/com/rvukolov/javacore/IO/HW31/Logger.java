package com.rvukolov.javacore.IO.HW31;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private StringBuilder log = new StringBuilder();
    private Date nowDate = new Date();
    private SimpleDateFormat nowDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void info(String string) {
        log.append(nowDateFormat.format(nowDate));
        log.append(" ");
        log.append(string);
        log.append("\n");
    }

    public void writeLog(File input) {
        String string = log.toString();
        try (FileWriter fw = new FileWriter(input)) {
                fw.write(string);
                fw.flush();
        } catch(IOException e) {
            info(string);
        }
    }

    public String getLog() {
        return log.toString();
    }
}
