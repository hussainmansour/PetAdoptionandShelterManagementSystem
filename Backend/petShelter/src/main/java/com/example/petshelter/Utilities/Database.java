package com.example.petshelter.Utilities;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Database {
    public static boolean Backup() {
        try {

            CodeSource codeSource = Database.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();


            /*NOTE: Creating Database Constraints*/
            String dbName = "sheltermanagement";
            String dbUser = "shelter";
            String dbPass = "Z123z!@#$";

            String folderPath = jarDir + "\\backup";

//            System.out.println(folderPath);

            File f1 = new File(folderPath);
            f1.mkdir();

            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql";

            System.out.println(savePath);

            String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;

//            System.out.println(executeCmd);

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup Complete");
                return true;
            } else {
                System.out.println("Backup Failure");
                return false;
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
        }

        return false;

    }


    public static boolean RestoreDB() {
        try {

            CodeSource codeSource = Database.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();

            String dbName = "sheltermanagement";
            String dbUser = "shelter";
            String dbPass = "Z123z!@#$";

            String restorePath = jarDir + "\\backup" + "\\" + "backup.sql";

            System.out.println(restorePath);

            String[] executeCmd = new String[]{"mysql", " -u " + dbUser, " -p" + dbPass, " -e", " \"source " + restorePath, "\" ", dbName};

//            System.out.println(String.join("",executeCmd));

            Process runtimeProcess = Runtime.getRuntime().exec(String.join("",executeCmd));
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " + "backup.sql");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error at restoring");
            }


        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
        }
        return false;

    }



}
