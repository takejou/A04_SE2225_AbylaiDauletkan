class OrdinaryComputerFactory implements ComputerFactory {
    @Override
    public Computer createComputer(int number) {
        return new Computer(number, ComputerCategory.ORDINARY);
    }
}