import java.util.List;

class ComputerAvailabilityMonitor implements ComputerAvailabilityObserver {
    private String name;

    public ComputerAvailabilityMonitor(String name) {
        this.name = name;
    }

    @Override
    public void updateAvailability(List<Computer> availableComputers, String time) {
        if (availableComputers.isEmpty()) {
            System.out.println("ComputerAvailabilityMonitor " + name + " at " + time + ": No available computers.");
        } else {
            System.out.println("ComputerAvailabilityMonitor " + name + " at " + time + ": Available computers - " + availableComputers);
        }
    }
}