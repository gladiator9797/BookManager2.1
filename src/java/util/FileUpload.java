/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author gladi
 */
public class FileUpload {

   private File myFile;
   private String myFileContentType;
   private String myFileFileName;
   private String destPath;

    public FileUpload() {
    }

    public FileUpload(File myFile, String myFileContentType, String myFileFileName, String destPath) {
        this.myFile = myFile;
        this.myFileContentType = myFileContentType;
        this.myFileFileName = myFileFileName;
        this.destPath = destPath;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

   public String execute() {
      /* Copy file to a safe location */
      destPath = "C:/Users/MrSunshine/Documents/NetBeansProjects/BookManager2.1/web/image";

      try {
         System.out.println("Src File name: " + myFile);
         System.out.println("Dst File name: " + myFileFileName);
     	    	 
         File destFile  = new File(destPath, myFileFileName);
         FileUtils.copyFile(myFile, destFile);
  
      } catch(IOException e) {
         e.printStackTrace();
         return ERROR;
      }

      return SUCCESS;
    }

   /*
    public String fileUploadAvatar() {
        destPathAvatar = "C:/Users/MrSunshine/Documents/NetBeansProjects/BookManager2.1/web/image/avatar";
        //destPathBook = "C:/Users/MrSunshine/Documents/NetBeansProjects/BookManager2.1/web/image/book";
        realPath = ServletActionContext.getServletContext().getRealPath("/");
        try {
            System.out.println("Source File name: " + myFile);
            System.out.println("Destination File name: " + myFileFileName);

            File destFile = new File(destPathAvatar, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }

    public String fileUploadBook() {
        //destPathAvatar = "C:/Users/MrSunshine/Documents/NetBeansProjects/BookManager/web/image/avatar";
        destPathBook = "C:/Users/MrSunshine/Documents/NetBeansProjects/BookManager2.1/web/image/book";
        try {
            System.out.println("Source File name: " + myFile);
            System.out.println("Destination File name: " + myFileFileName);

            File destFile = new File(destPathBook, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }
*/
    public String randomString(int size) {

        String str01 = "abcdefghijklmnopqrstuvwxyz";
        String str02 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str03 = "0123456789";

        // These are the valid charecters use to random.
        // Đây là các ký tự được dùng để chuỗi ký tự ngẫu nhiên.
        String strValid = str01 + str02 + str03;

        Random random = new Random();

        String mystring = "";
        for (int i = 0; i < size; i++) {
            int randnum = random.nextInt(strValid.length());
            mystring = mystring + strValid.charAt(randnum);
        }
        return mystring;
    }

    /*public static void main(String[] args) {
        FileUpload f = new FileUpload();
        String x = f.realPath;
        System.out.println(x);
    }*/
}
