// File Path: E:\java_sem2\Inovetive_Assingment\data\admin (Path we used in our program)
// Package: bus_pack

// package bus_pack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class admin {
    String Password;
    String login_id;

    public admin(String s1, String s2) {
        login_id = s2;
        Password = s1;

    }

    public void Store_password() {
        try {
            FileWriter fwrite = new FileWriter(
                    "E:\\java_sem2\\Inovetive_Assingment\\data\\admin\\" + login_id + ".txt");
            // writing the content into the FileOperationExample.txt file

            fwrite.write(Password);
            // Closing the stream
            fwrite.close();
            System.out.println("Content is successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    public String read_password() {
        String filedata = "";
        try {
            // Create f1 object of the file to read data
            File f1 = new File("E:\\java_sem2\\Inovetive_Assingment\\data\\admin\\" + login_id + ".txt");

            Scanner dataReader = new Scanner(f1);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                // System.out.println(fileData);
                filedata = filedata + fileData;
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexcpected error occurred!");
            exception.printStackTrace();
        }
        return filedata;
    }
}
