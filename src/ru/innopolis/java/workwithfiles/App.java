package ru.innopolis.java.workwithfiles;

import java.io.FileInputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args){
        String path = "./src/ru/innopolis/java/workWithFiles/data/input.txt";
        // try with resources
        try(FileInputStream fileInputStream = new FileInputStream(path)) {
            int read = fileInputStream.read();
            while (read >= 0) {
                System.out.println((char)read);
                read = fileInputStream.read();
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
