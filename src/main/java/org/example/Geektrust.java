package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Geektrust
{
    public static void main( String[] args )
    {
        String filePath = args[0];
        TheLedgerServices theLedgerServices = new TheLedgerServices();

        File file = new File(filePath);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String command = sc.nextLine();
                theLedgerServices.processCommand(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!! Please check the file and the location provided!");
        }

    }
}
