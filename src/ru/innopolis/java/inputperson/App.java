package ru.innopolis.java.inputperson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String path = "./src/ru/innopolis/java/workwithdata/data/info.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine(); // \n
            Person [] persons = new Person[10];
            int num = 0;
            while(line != null) {
                String [] params = line.split("\\|");
                Person newPerson = new Person(
                        params[0],
                        params[1],
                        Integer.parseInt(params[2])
                );
                persons[num] = newPerson;
                System.out.println(newPerson);
                num++;
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
