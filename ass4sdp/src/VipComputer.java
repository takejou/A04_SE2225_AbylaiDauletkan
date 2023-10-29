class VipComputer extends Computer {
    public VipComputer(int number) {
        super(number, ComputerCategory.VIP);
        this.isAvailable = true;
    }
}