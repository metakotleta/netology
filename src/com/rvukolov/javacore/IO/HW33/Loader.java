package com.rvukolov.javacore.IO.HW33;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//import com.rvukolov.javacore.IO.HW32.GameProgress;

public class Loader {

    public void unZip(String zipName) {
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(Main.SAVE_DIR + File.separator + zipName))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                FileOutputStream fos = new FileOutputStream(Main.SAVE_DIR + File.separator + fileName);
                byte[] buffer = new byte[zis.available()];
                while (zis.read(buffer) != -1) {
                    fos.write(buffer);
                }
                fos.flush();
                zis.closeEntry();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public GameProgress loadSavedGame(String fileName) {
        try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fileName))) {
            return (GameProgress) oin.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
