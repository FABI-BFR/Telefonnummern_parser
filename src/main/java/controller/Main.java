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
 * Controller nimmt eingabe entgegen und sorgt für die weitere Verarbeitung.
 *
 * @author fe
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.openMenu();
    }

}