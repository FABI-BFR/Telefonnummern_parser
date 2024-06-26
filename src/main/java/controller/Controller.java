package controller;

import data.PhoneNumber;
import data_handling.Formatter;
import data_handling.Parser;
import persistence.Database;
import persistence.ReadService;
import persistence.WriteService;

import java.util.List;
import java.util.Scanner;

/**
 * The Controller class is responsible for the representation of the menu and the start of the following procedures.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */

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

    /**
     * Displays the console menu
     */
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

    /**
     * Reads the phonenumber put in => parses and saves it.
     */
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

    /**
     * Retrieves all saved phonenumbers
     */
    private void getNumbers() {
        List<PhoneNumber> numbers = this.reader.getAllNumbers();
        for (PhoneNumber number : numbers) {
            System.out.println(this.formatter.getOriginalFormat(number));
        }
    }

}
