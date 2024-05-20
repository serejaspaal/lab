class CallingState implements PhoneState {
    @Override
    public boolean call(Phone phone) {
        System.out.println("Осуществляется вызов...");
        return false;
    }

    @Override
    public boolean answer(Phone phone) {
        phone.setState(new TalkingState());
        System.out.println("Вызов принят.");
        return true;
    }

    @Override
    public boolean endCall(Phone phone) {
        phone.setState(new WaitingState());
        System.out.println("Вызов завершен.");
        return true;
    }

    @Override
    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Баланс пополнен: " + amount);
    }
}