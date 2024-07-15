package com.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManagement eventManagement = new EventManagement();
        ParticipantManagement participantManagement = new ParticipantManagement();
        RegistrationManagement registrationManagement = new RegistrationManagement();

            try {
                System.out.println("\nEvent Management System");
                System.out.println("1. Event Management");
                System.out.println("2. Participant Management");
                System.out.println("3. Registration Management");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleEventManagement(scanner, eventManagement);
                        break;
                    case 2:
                        handleParticipantManagement(scanner, participantManagement);
                        break;
                    case 3:
                        handleRegistrationManagement(scanner, registrationManagement);
                        break;
                    case 4:
                        System.out.println("Exiting the application.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

    private static void handleEventManagement(Scanner scanner, EventManagement eventManagement) {
        try {
            System.out.println("\nEvent Management");
            System.out.println("1. Add a new event");
            System.out.println("2. View event details");
            System.out.println("3. Update event information");
            System.out.println("4. Delete an event");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    eventManagement.addEvent();
                    break;
                case 2:
                    eventManagement.viewEventDetails();
                    break;
                case 3:
                    eventManagement.updateEventInformation();
                    break;
                case 4:
                    eventManagement.deleteEvent();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private static void handleParticipantManagement(Scanner scanner, ParticipantManagement participantManagement) {
        try {
            System.out.println("\nParticipant Management");
            System.out.println("1. Register a new participant");
            System.out.println("2. View participant details");
            System.out.println("3. Update participant information");
            System.out.println("4. Delete a participant");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    participantManagement.registerParticipant();
                    break;
                case 2:
                    participantManagement.viewParticipantDetails();
                    break;
                case 3:
                    participantManagement.updateParticipantInformation();
                    break;
                case 4:
                    participantManagement.deleteParticipant();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }

    private static void handleRegistrationManagement(Scanner scanner, RegistrationManagement registrationManagement) {
        try {
            System.out.println("\nRegistration Management");
            System.out.println("1. Register a participant for an event");
            System.out.println("2. View registration details");
            System.out.println("3. Cancel a registration");
            System.out.println("4. List participants for a specific event");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registrationManagement.registerParticipantForEvent();
                    break;
                case 2:
                    registrationManagement.viewRegistrationDetails();
                    break;
                case 3:
                    registrationManagement.cancelRegistration();
                    break;
                case 4:
                    registrationManagement.listParticipantsForEvent();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
}
