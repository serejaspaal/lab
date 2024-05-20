class PhoneObserver implements Observer {
    private String observerName;

    public PhoneObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(String state) {
        System.out.println(observerName + " уведомлен. Новое состояние: " + state);
    }
}