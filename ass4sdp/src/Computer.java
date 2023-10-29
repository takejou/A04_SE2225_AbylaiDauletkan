class Computer {
    protected int number;
    protected boolean isAvailable;
    private Visitor currentVisitor;
    protected ComputerCategory category;

    public Computer(int number, ComputerCategory category) {
        this.number = number;
        this.category = category;
        this.isAvailable = true;
    }
    @Override
    public String toString() {
        String availability = isAvailable ? "Available" : "Reserved";
        return "Computer " + number + " in category " + category + " is " + availability;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public ComputerCategory getCategory() {
        return category;
    }

    public Visitor getCurrentVisitor() {
        return currentVisitor;
    }

    public void reserve(Visitor visitor) {
        isAvailable = false;
        currentVisitor = visitor;
    }

    public void free() {
        isAvailable = true;
        currentVisitor = null;
    }
}