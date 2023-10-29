class Reservation {
    private Computer computer;
    private String time;
    private Visitor visitor;

    public Reservation(Computer computer, String time, Visitor visitor) {
        this.computer = computer;
        this.time = time;
        this.visitor = visitor;  // Инициализация объекта Visitor
    }

    public Computer getComputer() {
        return computer;
    }

    public String getTime() {
        return time;
    }

    public Visitor getVisitor() {
        return visitor;
    }
}
