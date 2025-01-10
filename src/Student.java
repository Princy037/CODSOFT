class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String birthDate;
    private String address;
    private String phone;

    public Student(String name, int rollNumber, String grade, String birthDate, String address, String phone) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade + "\nBirth Date: " + birthDate +
                "\nAddress: " + address + "\nPhone: " + phone;
    }
}
