package frc.robot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class EncoderFile {


    public static void writeValue(double value){

        try {
            Writer fileWriter = new FileWriter("EncoderFile.txt", false);
            fileWriter.write(String.valueOf(value));
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
        }
    }

    public static double readValue(){
        double value = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("EncoderFile.txt"))){
            value = Double.valueOf(reader.readLine());
        } catch (Exception e) {
        }
        
        return value;
    }
}
