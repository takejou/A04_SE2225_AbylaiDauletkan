class Administrator implements ComputerClubObserver {
    private String name;

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public void update(Reservation reservation) {
        System.out.println("Administrator " + name + " received a notification: " +
                "Computer " + reservation.getComputer().getNumber() +
                " in category " + reservation.getComputer().getCategory() +
                " has been reserved by " + reservation.getVisitor().getName() +
                " at " + reservation.getTime());
    }
}
