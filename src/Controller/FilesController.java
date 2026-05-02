package Controller;

import Interface.FilesInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FilesController implements FilesInterface {


    @Override
    public void writeTextToFileIO(String text, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(text);
            bw.newLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readTextFromFileIO(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
