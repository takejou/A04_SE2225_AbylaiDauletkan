import java.util.List;

interface ComputerAvailabilityObserver {
    void updateAvailability(List<Computer> availableComputers, String time);
}