# Hospital Appointment Booking System

A Java-based desktop application for managing hospital appointments, built using Swing GUI framework and H2 in-memory database.

## Features

- **Doctor Management**: View list of available doctors with their specializations
- **Appointment Booking**: Book appointments with doctors
- **Appointment Viewing**: View all booked appointments
- **Multithreaded Loading**: Smooth loading experience with background thread
- **Database Integration**: Persistent storage using H2 in-memory database

## Technologies Used

- **Java**: Core programming language
- **Swing**: GUI framework for desktop interface
- **H2 Database**: In-memory database for data persistence
- **JDBC**: Database connectivity

## Project Structure

```
Hospital Appointment Booking System/
├── src/
│   ├── HospitalManagementSystem.java    # Main application class
│   ├── database/
│   │   ├── DBConnection.java            # Database connection management
│   │   └── AppointmentDAO.java          # Data access object for appointments
│   ├── gui/
│   │   ├── DoctorPanel.java             # Doctors list panel
│   │   ├── AppointmentPanel.java        # Appointment booking panel
│   │   └── ViewAppointmentsPanel.java   # Appointments viewing panel
│   ├── model/
│   │   ├── Doctor.java                  # Doctor model class
│   │   ├── Appointment.java             # Appointment model class
│   │   ├── Patient.java                 # Patient model class
│   │   ├── Person.java                  # Abstract person class
│   │   └── DBException.java             # Custom database exception
│   └── threads/
│       └── LoadingThread.java           # Loading thread for UI
├── bin/                                 # Compiled classes
├── lib/                                 # External libraries
│   └── h2-2.1.214.jar                   # H2 database driver
└── README.md                            # This file
```

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- No additional database setup required (uses H2 in-memory database)

## How to Run

1. **Clone or download the project**

2. **Compile the project:**
   ```bash
   javac -d bin src/HospitalManagementSystem.java src/database/*.java src/gui/*.java src/model/*.java src/threads/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp "bin;lib/h2-2.1.214.jar" HospitalManagementSystem
   ```

   Note: On Unix/Linux systems, use `:` instead of `;` as the classpath separator:
   ```bash
   java -cp "bin:lib/h2-2.1.214.jar" HospitalManagementSystem
   ```

## Usage

1. **Doctors Tab**: View the list of available doctors and their specializations
2. **Book Appointment Tab**:
   - Enter patient name
   - Select doctor from dropdown
   - Choose appointment date
   - Click "Book Appointment"
3. **View Appointments Tab**: See all booked appointments in a table format

## Database

The application uses H2 in-memory database which:
- Stores data in memory (data persists during application runtime)
- Automatically creates the required tables
- No external database server required
- Data is lost when application closes

## Troubleshooting

- **Compilation errors**: Ensure all source files are compiled together
- **Runtime errors**: Make sure the H2 jar file is in the lib directory and included in classpath
- **GUI not displaying**: Check Java installation and Swing support

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is open source and available under the Gu License.

