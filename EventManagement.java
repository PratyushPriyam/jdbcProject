package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class EventManagement {
    public void addEvent() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event name: ");
            String name = scanner.nextLine();

            System.out.print("Enter event date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter event location: ");
            String location = scanner.nextLine();

            System.out.print("Enter event capacity: ");
            int capacity = scanner.nextInt();

            String sql = "INSERT INTO Event (name, date, location, capacity) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, date);
                stmt.setString(3, location);
                stmt.setInt(4, capacity);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Event added successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEventDetails() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();

            String sql = "SELECT * FROM Event WHERE event_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, eventId);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Event ID: " + rs.getInt("event_id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Date: " + rs.getDate("date"));
                        System.out.println("Location: " + rs.getString("location"));
                        System.out.println("Capacity: " + rs.getInt("capacity"));
                    } else {
                        System.out.println("Event not found!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEventInformation() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new event name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new event date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter new event location: ");
            String location = scanner.nextLine();

            System.out.print("Enter new event capacity: ");
            int capacity = scanner.nextInt();

            String sql = "UPDATE Event SET name = ?, date = ?, location = ?, capacity = ? WHERE event_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, date);
                stmt.setString(3, location);
                stmt.setInt(4, capacity);
                stmt.setInt(5, eventId);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Event updated successfully!");
                } else {
                    System.out.println("Event not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent() {
        try (Connection conn = DatabaseConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter event ID: ");
            int eventId = scanner.nextInt();

            String sql = "DELETE FROM Event WHERE event_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, eventId);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Event deleted successfully!");
                } else {
                    System.out.println("Event not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

