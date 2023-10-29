interface ComputerClubSubject {
    void addObserver(ComputerClubObserver observer);
    void removeObserver(ComputerClubObserver observer);
    void notifyObservers(Reservation reservation);
}
