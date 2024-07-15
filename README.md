# jdbcProject #74

The codes in this file are a part of my training project. The topic was to develop a menu-based console application and connect it using JDBC. 

There are 5 java files and 1 sql file in the repository.

1. "MainMenu.java" contains the codes for the main menu which is created using switch statements. The switch statements are a form of
conditional statements. The main menu also contains the "public static void main(String[] args)" which signify that the code processing starts from here.
The switch statements based on the inputs provided by the user choose a certain condition and go foreward with them, completing one cycle in this fashion.

2. "DatabaseCOnnection.java" contains the code for connection the database with the java code. There are three constants in this code - URL, USER and PASSWORD.
Using there details, the java code connects with the sql server which is hosted locally. The getConnection() function returns a COnnection object to the code calling it.

3. "EventManagement.java" contains codes to handle Event related queries like adding new events, viewing already present event details, update saved event details and delete events. These functions are executed using seperate functions that perform these logics. The logics in these functions are executed using PreparedStatements, these statements in jdbc represent parameterized sql queries. These querise can take dynamic values during runtime making it an efficient way of communication.

4. "ParticipantManagement" similar to the EventManagement class, this class focusses on doing works related to the participation of people in these events.The core logics executed by this class are - registering participants, view participant details, update participant information and delete participants.

5. "RegistrationManagement" similar to EventManagement and ParticipantManagement, this class deals with Registration Management tasks like - Registering participant for the event, view registration details and cancel registration.

The last file is the SQL_Codes.sql file which contains the sql codes which were used to create the database schemas and for giving columns their identities. The name of the database is - event_management. The various tables inside this database are - Event, Participant and Registration. The event and participant tables have event_id and participant_id as their primary keys and have no foreign keys, whereas the Registration table has registration_id as primary key and event_id and participant_id from the Event and Participant tables as their foreign keys.
