class WaitingState implements PhoneState {
    @Override
    public boolean call(Phone phone) {
        if (phone.getBalance() > 0) {
            phone.setState(new CallingState());
            System.out.println("Вызов...");
            return true;

        } else {
            phone.setState(new BlockedState());
            System.out.println("Вызов невозможен, низкий баланс.");
            return false;
        }
    }

    @Override
    public boolean answer(Phone phone) {
        System.out.println("Не имеется входящих вызовов.");
        return false;
    }

    @Override
    public boolean endCall(Phone phone) {
        System.out.println("Не имеется вызовов для завершения.");
        return false;
    }

    @Override
    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        System.out.println("Баланс пополнен: " + amount);
    }
}