class BlockedState implements PhoneState {
    @Override
    public boolean call(Phone phone) {
        System.out.println("Звонок невозможен, баланс отрицательный");
        return false;
    }

    @Override
    public boolean answer(Phone phone) {
        System.out.println("Принять вызов невозможно, баланс отрицательный");
        return false;
    }

    @Override
    public boolean endCall(Phone phone) {
        System.out.println("Вызов завершен.");
        return true;
    }

    @Override
    public void recharge(Phone phone, double amount) {
        phone.setBalance(phone.getBalance() + amount);
        if (phone.getBalance() > 0) {
            phone.setState(new WaitingState());
            System.out.println("Баланс положительный, тариф разблокирован.");
        } else {
            System.out.println("Баланс пополнен. Внимание: баланс все еще отрицательный.");
        }
    }
}