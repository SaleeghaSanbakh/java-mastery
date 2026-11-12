public class Passenger {
    private final String passportNumber;
    private String name;

    public Passenger(String name, String passportNumber) {
        this.name = validateName(name);
        this.passportNumber = validatePassport(passportNumber);
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void changeName(String newName) {
        this.name = validateName(newName);
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        return name.strip();   // removes extra spaces: "  Geetha " → "Geetha"
    }

    private String validatePassport(String passportNumber) {
        if (passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException("Passport number is required");
        }
        return passportNumber.strip().toUpperCase();
    }

    @Override
    public String toString() {
        return "Passenger{name='" + name + "', passport='" + passportNumber + "'}";
    }

    public static void main(String[] args) {
        Passenger p1 = new Passenger("Seetha", "u123456");
        System.out.println(p1);                 // Passenger{name='Seetha', passport='U123456'}

        p1.changeName("Geetha");
        System.out.println(p1.getName());       // Geetha

        try {
            p1.changeName("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());   // Rejected: Name is required
        }
    }
}