class OrdinaryComputer extends Computer {
    public OrdinaryComputer(int number) {
        super(number, ComputerCategory.ORDINARY);
        this.isAvailable = true;
    }
}