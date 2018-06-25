/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gladi
 */
public class FileCompress {

    private String backup;
    private String filePath = "C:\\Users\\MrSunshine\\Documents\\NetBeansProjects\\BookManager2.1";
    private String inputFilePath;

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String compress() {
        //DataProcess DP = new DataProcess();
        if (backup != null) {
            try {
                // goi cmd, thuc hien command 7za...
                //    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "7za a BookManager.7z");     
                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "7za a " + backup);
                //chuyen thu muc den C:\\.....
                builder.directory(new File(filePath));
                // thực thi command line
                Process p = builder.start();
                // lấy kết quả trả về trên command line
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                while (true) {
                    line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
            } catch (IOException ex) {
                System.out.println("Fail!!!!: " + ex.toString());
            }
            /*    File f = new File(filePath);
        if (f.exists() && !f.isDirectory()) {
            return "fileExist";
        }
             */
            return "success";
        } else {
            return "fail";
        }
    }
    
    public String redirect(){
        return "success";
    }
    
}
