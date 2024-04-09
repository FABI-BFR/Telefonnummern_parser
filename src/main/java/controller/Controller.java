package controller;

import data.PhoneNumber;
import data_handling.Formatter;
import data_handling.Parser;
import persistence.Database;
import persistence.ReadService;
import persistence.WriteService;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private final ReadService reader;
    private final WriteService writer;
    private final Formatter formatter;

    public Controller() {
        Database db = new Database();
        this.reader = db;
        this.writer = db;
        this.formatter = new Formatter();
    }


    public void openMenu() {

        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("[1] Telefonnummer speichern.");
            System.out.println("[2] Telefonnummern abrufen.");
            System.out.print("Choose:");
            int input = this.scanner.nextInt();
            this.scanner.nextLine();
            switch (input) {
                case 1:
                    saveNumber();
                    break;
                case 2:
                    getNumbers();
                    break;
            }
        }
    }

    private void saveNumber() {
        System.out.println("Bitte geben Sie eine Telefonnummer ein:");
        String input = scanner.nextLine();

        InputCheck inputCheck = new InputCheck();
        if (inputCheck.isValidPhoneNumber(input)) {
            Parser parser = new Parser();
            PhoneNumber number = parser.parseStringToPhoneNumberEx(input);
            writer.setPhoneNumber(0, number);
            System.out.println(number.toString());
        }
    }

    private void getNumbers() {
        List<PhoneNumber> numbers = this.reader.getAllNumbers();
        for (PhoneNumber number : numbers) {
            System.out.println(this.formatter.getOriginalFormat(number));
        }
    }

}
