package com.foo.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesTest {
    
    public static void main(String[] args) {
        InputStream input = null;

        try {
             input = new FileInputStream("file.txt");

             int data = input.read();
             while(data != -1){
                System.out.print((char) data);
                data = input.read();
             }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        try (InputStream in = Files.newInputStream(Paths.get("file.txt"))) {
            int data = in.read();
            while(data != -1){
                System.out.print((char) data);
                data = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
