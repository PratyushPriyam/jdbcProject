package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class ParticipantManagement {
    public void registerParticipant() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter participant name: ");
            String name = scanner.nextLine();

            System.out.print("Enter participant email: ");
            String email = scanner.nextLine();

            System.out.print("Enter participant phone number: ");
            String phoneNumber = scanner.nextLine();

            String sql = "INSERT INTO Participant (name, email, phone_number) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phoneNumber);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Participant registered successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewParticipantDetails() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter participant ID: ");
            int participantId = scanner.nextInt();

            String sql = "SELECT * FROM Participant WHERE participant_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, participantId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Participant ID: " + rs.getInt("participant_id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email: " + rs.getString("email"));
                        System.out.println("Phone Number: " + rs.getString("phone_number"));
                    } else {
                        System.out.println("Participant not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateParticipantInformation() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter participant ID: ");
            int participantId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter new participant name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new participant email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new participant phone number: ");
            String phoneNumber = scanner.nextLine();

            String sql = "UPDATE Participant SET name = ?, email = ?, phone_number = ? WHERE participant_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, phoneNumber);
                stmt.setInt(4, participantId);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Participant updated successfully!");
                } else {
                    System.out.println("Participant not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteParticipant() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter participant ID: ");
            int participantId = scanner.nextInt();

            String sql = "DELETE FROM Participant WHERE participant_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, participantId);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Participant deleted successfully!");
                } else {
                    System.out.println("Participant not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

