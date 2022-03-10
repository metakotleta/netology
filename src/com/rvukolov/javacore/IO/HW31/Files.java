package com.rvukolov.javacore.IO.HW31;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
    Logger logger = new Logger();

    public File makeFile(File parent, String name)  {
        File child = new File(parent, name);
        try {
            if (child.createNewFile()) {
                logger.info("Файл создан: " + child.getAbsolutePath());
            }
            return child;
        } catch (IOException e) {
            logger.info("Файл не создан: " + child.getAbsolutePath() + ": " + e.getMessage());
            return null;
        }
    }

    public File makeDir(File parent, String name) {
        File child = new File(parent, name);
        if (child.mkdir()) {
            logger.info("Директория создана: " + child.getAbsolutePath());
        } else {
            logger.info("Директория не создана: " + child.getAbsolutePath());
        }
        return child;
    }

    public File makeDir(String parentPath, String name) {
        File child = new File(parentPath, name);
        if (child.mkdir()) {
            logger.info("Директория создана: " + child.getAbsolutePath());
        } else {
            logger.info("Директория не создана: " + child.getAbsolutePath());
        }
        return child;
    }

    public void writeLogFile(File file) {
        logger.writeLog(file);
    }
}
