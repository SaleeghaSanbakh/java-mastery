public class SkywardsMember extends Passenger {
    private final String membershipNumber;
    private int miles;

    public SkywardsMember(String name, String passportNumber, String membershipNumber) {
        super(name, passportNumber);
        this.membershipNumber = validateMembershipNumber(membershipNumber);
    }

    public void addMiles(int milesEarned) {
        if (milesEarned <= 0) {
            throw new IllegalArgumentException("Miles must be positive");
        }
        miles += milesEarned;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public int getMiles() {
        return miles;
    }

    private String validateMembershipNumber(String membershipNumber) {
        if (membershipNumber == null || membershipNumber.isBlank()) {
            throw new IllegalArgumentException("Membership number is required");
        }
        return membershipNumber.strip().toUpperCase();
    }

    @Override
    public String boardingGroup() {
        return "Priority";
    }

    public static void main(String[] args) {
        SkywardsMember member1 = new SkywardsMember("Seetha", "u123456", "abc12345");
        member1.addMiles(50);
        System.out.println(member1.getName());              // Seetha (inherited)
        System.out.println(member1.getMiles());             // 50
        System.out.println(member1.getMembershipNumber());  // ABC12345

        try {
            member1.addMiles(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add miles: " + e.getMessage());
        }
    }
}