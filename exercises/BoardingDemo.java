import java.util.List;

public class BoardingDemo {
    public static void main(String[] args) {
        List<Passenger> queue = List.of(
                new Passenger("Ali", "P111"),
                new Passenger("Fatima", "P222"),
                new SkywardsMember("Seetha", "U123456", "EK998877")
        );

        for (Passenger p : queue) {
            System.out.println(p.getName() + ": " + p.boardingGroup());
        }
    }
}