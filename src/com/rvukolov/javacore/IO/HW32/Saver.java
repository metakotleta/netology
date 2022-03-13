package com.rvukolov.javacore.IO.HW32;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Saver {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("ddhhmmssS");

    private List<String> fileCounter() {
        String[] saveFiles = Main.SAVE_DIR.list();
        List<String> datFiles = new ArrayList<>();

        for (int i = 0; i < saveFiles.length; i++) {
            if (Pattern.matches(Main.saveFileMask, saveFiles[i])) {
                datFiles.add(saveFiles[i]);
            }
        }
        return datFiles;
    }

    private void zipSaveFiles (List<String> datFiles) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(Main.SAVE_DIR + File.separator
                + "savefiles.zip"))) {
            for (int i = 0; i < datFiles.size(); i++) {
                FileInputStream fis = new FileInputStream(Main.SAVE_DIR + File.separator + datFiles.get(i));
                ZipEntry entry = new ZipEntry(datFiles.get(i));
                zos.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
                fis.close();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void deleteDat(List<String> datFiles) {
        for (int i = 0; i < datFiles.size(); i++) {
            File datFileToDelete = new File(Main.SAVE_DIR + File.separator + datFiles.get(i));
            datFileToDelete.delete();
        }
    }

    public void saveGameState (GameProgress gProg) throws IOException {
        String saveDate = dateFormat.format(new Date());
        try (FileOutputStream fos = new FileOutputStream(Main.SAVE_DIR + File.separator + "savefile" + saveDate + ".dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gProg);
            System.out.println(Main.SAVE_DIR.getAbsolutePath());
        } catch (FileNotFoundException fnf) {
            System.out.println("Невозможно создать файл");
        }
        zipSaveFiles(fileCounter());
    }

    public void clearDatFiles() {
        deleteDat(fileCounter());
    }
}
