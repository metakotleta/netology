package com.rvukolov.javacore.IO.HW33;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
//import com.rvukolov.javacore.IO.HW32.GameProgress;

public class Loader {

    public List<String> getFileNames() {
        String[] saveFiles = com.rvukolov.javacore.IO.HW32.Main.SAVE_DIR.list();
        List<String> datFiles = new ArrayList<>();

        for (int i = 0; i < saveFiles.length; i++) {
            if (Pattern.matches(com.rvukolov.javacore.IO.HW32.Main.saveFileMask, saveFiles[i])) {
                datFiles.add(saveFiles[i]);
            }
        }
        return datFiles;
    }

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
