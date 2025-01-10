import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagementSystem extends JFrame {
    private ArrayList<Student> students;
    private JTextField nameField, rollNumberField, gradeField, birthDateField, addressField, phoneField;
    private JTextArea studentTextArea;
    private JButton addButton, removeButton, searchButton, displayButton;

    private Color primaryColor = new Color(51, 153, 255); // Light blue color
    private Color buttonColor = new Color(0, 102, 204); // Dark blue for buttons
    private Color textColor = new Color(255, 255, 255); // White text
    private Color backgroundColor = new Color(240, 240, 240); // Light gray for background

    public StudentManagementSystem() {
        students = new ArrayList<>();
        setTitle("Student Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center window on screen

        // Set background color for the JFrame
        getContentPane().setBackground(backgroundColor);

        // Create UI elements
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberField = new JTextField(20);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(20);

        JLabel birthDateLabel = new JLabel("Birth Date (YYYY-MM-DD):");
        birthDateField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField(20);

        addButton = new JButton("Add Student");
        removeButton = new JButton("Remove Student");
        searchButton = new JButton("Search Student");
        displayButton = new JButton("Display All Students");

        studentTextArea = new JTextArea(10, 40);
        studentTextArea.setEditable(false);
        studentTextArea.setBackground(Color.LIGHT_GRAY);
        studentTextArea.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(studentTextArea);

        // Set layout for the JFrame
        setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));
        inputPanel.setBackground(backgroundColor);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(rollNumberLabel);
        inputPanel.add(rollNumberField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);
        inputPanel.add(birthDateLabel);
        inputPanel.add(birthDateField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        // Set colors for the buttons
        addButton.setBackground(buttonColor);
        removeButton.setBackground(buttonColor);
        searchButton.setBackground(buttonColor);
        displayButton.setBackground(buttonColor);
        addButton.setForeground(textColor);
        removeButton.setForeground(textColor);
        searchButton.setForeground(textColor);
        displayButton.setForeground(textColor);

        // Add components to JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add event listeners to buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
            }
        });
    }

    // Add student to the list
    private void addStudent() {
        String name = nameField.getText();
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        String grade = gradeField.getText();
        String birthDate = birthDateField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        // Validate input fields
        if (!name.isEmpty() && !grade.isEmpty() && !birthDate.isEmpty() && !address.isEmpty() && !phone.isEmpty()) {
            Student student = new Student(name, rollNumber, grade, birthDate, address, phone);
            students.add(student);
            clearFields();

            int option = JOptionPane.showConfirmDialog(this, "Student added successfully! Would you like to add more details?", "Add More Details", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Add more details for the student, if needed
                JOptionPane.showMessageDialog(this, "You can edit the student details in the search or display section.", "Edit Student", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Remove student by roll number
    private void removeStudent() {
        try {
            int rollNumber = Integer.parseInt(rollNumberField.getText());
            Student studentToRemove = null;
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    studentToRemove = student;
                    break;
                }
            }

            if (studentToRemove != null) {
                students.remove(studentToRemove);
                JOptionPane.showMessageDialog(this, "Student removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid roll number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Search for a student by roll number
    private void searchStudent() {
        try {
            int rollNumber = Integer.parseInt(rollNumberField.getText());
            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    studentTextArea.setText(student.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Student not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid roll number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Display all students
    private void displayAllStudents() {
        studentTextArea.setText("");
        for (Student student : students) {
            studentTextArea.append(student.toString() + "\n");
        }
    }

    // Clear the input fields
    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
        gradeField.setText("");
        birthDateField.setText("");
        addressField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}

