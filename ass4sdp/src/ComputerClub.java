import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


class ComputerClub implements ComputerClubSubject {
    private List<ComputerClubObserver> observers = new ArrayList<>();
    private List<Computer> computers = new ArrayList<>();
    private List<ComputerAvailabilityObserver> availabilityObservers = new ArrayList<>();
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    @Override
    public void addObserver(ComputerClubObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ComputerClubObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Reservation reservation) {
        for (ComputerClubObserver observer : observers) {
            observer.update(reservation);
        }
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void addAvailabilityObserver(ComputerAvailabilityObserver observer) {
        availabilityObservers.add(observer);
    }

    public void removeAvailabilityObserver(ComputerAvailabilityObserver observer) {
        availabilityObservers.remove(observer);
    }


    public void showAvailableComputers() {
        for (Computer computer : computers) {
            if (computer.isAvailable()) {
                System.out.println("Computer " + computer.getNumber() +
                        " in category " + computer.getCategory() +
                        " is available: \u001B[32mAvailable\u001B[0m"); // Зеленый цвет для доступных
            } else {
                System.out.println("Computer " + computer.getNumber() +
                        " in category " + computer.getCategory() +
                        " is reserved: \u001B[31mReserved\u001B[0m"); // Красный цвет для зарезервированных
            }
        }
    }


    public Computer getComputerByNumber(int number) {
        for (Computer computer : computers) {
            if (computer.getNumber() == number) {
                return computer;
            }
        }
        return null;
    }

    public void makeReservation(Reservation reservation) {
        Computer computer = reservation.getComputer();
        Visitor visitor = reservation.getVisitor();
        if (computer.isAvailable()) {
            computer.reserve(visitor);
            System.out.println("Reservation successful.");
            notifyObservers(reservation);
        } else if (computer.getCurrentVisitor() != null && computer.getCurrentVisitor().equals(visitor)) {
            computer.free();
            System.out.println("Reservation canceled.");
            notifyObservers(reservation);
        } else {
            System.out.println("Computer " + computer.getNumber() + " is already reserved.");
        }
    }

    private void notifyAvailabilityObservers() {
        List<Computer> availableComputers = new ArrayList<>();
        for (Computer computer : computers) {
            if (computer.isAvailable()) {
                availableComputers.add(computer);
            }
        }

        String currentTime = getCurrentTime(); // Реализуйте логику получения текущего времени
        for (ComputerAvailabilityObserver observer : availabilityObservers) {
            observer.updateAvailability(availableComputers, currentTime);
        }
    }
} 