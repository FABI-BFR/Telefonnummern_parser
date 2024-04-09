package controller;

import data.PhoneNumber;
import data_handling.Parser;

import java.util.Scanner;

/**
 * Controller nimmt eingabe entgegen und sorgt für die weitere Verarbeitung.
 * @author fe
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Telefonnummer ein:");
        String input = scanner.nextLine();

        InputCheck inputCheck = new InputCheck();
        if(inputCheck.isValidPhoneNumber(input)){
            Parser parser = new Parser();
            PhoneNumber number = parser.parseStringToPhoneNumberEx(input);
            System.out.println(number.toString());
        }

    }
}