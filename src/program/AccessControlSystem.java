package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AccessControlSystem {

    static private List<Byte> clientsAges = new ArrayList<>();
    static int under18YearsOld;
    static int between18And50YearsOld;
    static int over50YearsOld;

    /**
     * Main Method.
     * The @param args is used to pass information into the program.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        byte option;
        byte age;

        do {
            printMenu();
            option = sc.nextByte();
            if (option == 1) {
                print("Enter the age:");
                age = sc.nextByte();
                printClientMessage(age);
                clientsAges.add(age);
            } else if (option == 2) {
                break;
            } else {
                print("Enter a valid option!");
            }
        } while (true);
        sc.close();
        printReport();
    }

    static void printReport() {
        StringBuilder reportText = new StringBuilder();
        reportText.append("----- Quantity -----");
        reportText.append("\n");
        reportText.append("under 18: %d");
        reportText.append("\n");
        reportText.append("adults: %d");
        reportText.append("\n");
        reportText.append("over 50: %d");
        reportText.append("\n");
        reportText.append("\n");
        reportText.append("----- Percentage -----");
        reportText.append("\n");
        reportText.append("under 18: %.2f%");
        reportText.append("\n");
        reportText.append("adults: %.2f%");
        reportText.append("\n");
        reportText.append("over 50: %.2f%");
        reportText.append("\n");
        reportText.append("\n");
        reportText.append("TOTAL: %d");
        reportText.append("\n");
        print(reportText);
    }

    static void printClientMessage(int age) {
        if (age < 18) {
            under18YearsOld += 1;
            print("Underage client, turnstile released!");
        } else if (age < 50) {
            between18And50YearsOld += 1;
            print("Adult client, turnstile released!");
        } else {
            over50YearsOld += 1;
            print("Adult client from 50 years old, turnstile released!");
        }
    }

    static void printMenu() {
        print("Enter the number corresponding to the desired option");
        print("1 - Access the establishment");
        print("2 - Finish the system and show the report");
    }

    static void print(String message) {
        System.out.println(message);
    }

    static float calculatePeoplesPercentage(int numberOfClients) {
        return numberOfClients * 100.0f / clientsAges.size();
    }

    static void print(StringBuilder reportText) {
        System.out.printf(
            reportText.toString(),
            under18YearsOld,
            between18And50YearsOld,
            over50YearsOld,
            calculatePeoplesPercentage(under18YearsOld),
            calculatePeoplesPercentage(between18And50YearsOld),
            calculatePeoplesPercentage(over50YearsOld),
            clientsAges.size()
        );
    }
}
