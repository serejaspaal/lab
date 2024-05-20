class TalkingState implements PhoneState {
    @Override
    public boolean call(Phone phone) {
        System.out.println("Already in a conversation.");
        return false;
    }

    @Override
    public boolean answer(Phone phone) {
        System.out.println("Вы уже на линии.");
        return false;
    }

    @Override
    public boolean endCall(Phone phone) {
        phone.setState(new WaitingState());
        phone.setBalance(phone.getBalance() - 5);
        System.out.println("Разговор завершен.");
        return true;
    }

    @Override
    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Баланс пополнен: " + amount);
    }
}