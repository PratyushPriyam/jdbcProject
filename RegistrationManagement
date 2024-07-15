package com.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class RegistrationManagement {
    public void registerParticipantForEvent() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();

            System.out.print("Enter participant ID: ");
            int participantId = scanner.nextInt();

            String checkCapacitySql = "SELECT capacity FROM Event WHERE event_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkCapacitySql)) {
                checkStmt.setInt(1, eventId);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        int capacity = rs.getInt("capacity");
                        if (capacity > 0) {
                            String sql = "INSERT INTO Registration (event_id, participant_id, registration_date) VALUES (?, ?, ?)";
                            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                                stmt.setInt(1, eventId);
                                stmt.setInt(2, participantId);
                                stmt.setDate(3, Date.valueOf(LocalDate.now()));

                                int rowsInserted = stmt.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("Registration successful!");

                                    String updateCapacitySql = "UPDATE Event SET capacity = capacity - 1 WHERE event_id = ?";
                                    try (PreparedStatement updateStmt = conn.prepareStatement(updateCapacitySql)) {
                                        updateStmt.setInt(1, eventId);
                                        updateStmt.executeUpdate();
                                    }
                                }
                            }
                        } else {
                            System.out.println("Event is fully booked!");
                        }
                    } else {
                        System.out.println("Event not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewRegistrationDetails() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter registration ID: ");
            int registrationId = scanner.nextInt();

            String sql = "SELECT * FROM Registration WHERE registration_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, registrationId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Registration ID: " + rs.getInt("registration_id"));
                        System.out.println("Event ID: " + rs.getInt("event_id"));
                        System.out.println("Participant ID: " + rs.getInt("participant_id"));
                        System.out.println("Registration Date: " + rs.getDate("registration_date"));
                    } else {
                        System.out.println("Registration not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelRegistration() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter registration ID: ");
            int registrationId = scanner.nextInt();

            String getEventIdSql = "SELECT event_id FROM Registration WHERE registration_id = ?";
            try (PreparedStatement getEventStmt = conn.prepareStatement(getEventIdSql)) {
                getEventStmt.setInt(1, registrationId);
                try (ResultSet rs = getEventStmt.executeQuery()) {
                    if (rs.next()) {
                        int eventId = rs.getInt("event_id");

                        String sql = "DELETE FROM Registration WHERE registration_id = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                            stmt.setInt(1, registrationId);

                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("Registration canceled successfully!");

                                String updateCapacitySql = "UPDATE Event SET capacity = capacity + 1 WHERE event_id = ?";
                                try (PreparedStatement updateStmt = conn.prepareStatement(updateCapacitySql)) {
                                    updateStmt.setInt(1, eventId);
                                    updateStmt.executeUpdate();
                                }
                            } else {
                                System.out.println("Registration not found!");
                            }
                        }
                    } else {
                        System.out.println("Registration not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listParticipantsForEvent() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();

            String sql = "SELECT p.participant_id, p.name, p.email, p.phone_number " +
                         "FROM Participant p " +
                         "JOIN Registration r ON p.participant_id = r.participant_id " +
                         "WHERE r.event_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, eventId);

                try (ResultSet rs = stmt.executeQuery()) {
                    System.out.println("Participants for Event ID " + eventId + ":");
                    while (rs.next()) {
                        System.out.println("Participant ID: " + rs.getInt("participant_id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Email: " + rs.getString("email"));
                        System.out.println("Phone Number: " + rs.getString("phone_number"));
                        System.out.println();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

