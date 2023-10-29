import java.util.Scanner;

public class ComputerClubDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String visitorName = scanner.nextLine();
        System.out.print("Enter your login: ");
        String visitorLogin = scanner.nextLine();

        Visitor visitor = new Visitor(visitorName, visitorLogin);

        ComputerClub computerClub = new ComputerClub();

        Administrator admin1 = new Administrator("First Admin Monitor");
        Administrator admin2 = new Administrator("Second Admin Monitor");
        computerClub.addObserver(admin1);
        computerClub.addObserver(admin2);

        ComputerAvailabilityMonitor availabilityMonitor = new ComputerAvailabilityMonitor("Monitor1");
        computerClub.addAvailabilityObserver(availabilityMonitor);

        ComputerFactory vipComputerFactory = new VipComputerFactory();
        ComputerFactory ordinaryComputerFactory = new OrdinaryComputerFactory();

        Computer vipComputer1 = vipComputerFactory.createComputer(1);
        Computer vipComputer2 = vipComputerFactory.createComputer(2);
        Computer ordinaryComputer1 = ordinaryComputerFactory.createComputer(3);
        Computer ordinaryComputer2 = ordinaryComputerFactory.createComputer(4);

        // available status
        vipComputer1.setAvailable(true);
        vipComputer2.setAvailable(true);
        ordinaryComputer1.setAvailable(true);
        ordinaryComputer2.setAvailable(true);

        computerClub.addComputer(vipComputer1);
        computerClub.addComputer(vipComputer2);
        computerClub.addComputer(ordinaryComputer1);
        computerClub.addComputer(ordinaryComputer2);


        String command;
        while (true) {
            System.out.println("Enter a command (reserve/exit): ");
            command = scanner.nextLine();
            if (command.equals("reserve")) {
                System.out.println("Available computers:");
                computerClub.showAvailableComputers();
                System.out.print("Enter the computer number to reserve: ");
                int computerNumber = scanner.nextInt();
                scanner.nextLine();
                Computer computer = computerClub.getComputerByNumber(computerNumber);
                if (computer != null) {
                    System.out.print("Enter the reservation time: ");
                    String time = scanner.nextLine();
                    Reservation reservation = new Reservation(computer, time, visitor);
                    computerClub.makeReservation(reservation);
                } else {
                    System.out.println("Invalid computer number.");
                }
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
}
