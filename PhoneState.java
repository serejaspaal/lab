interface PhoneState {
    boolean call(Phone phone);
    boolean answer(Phone phone);
    boolean endCall(Phone phone);
    void recharge(Phone phone, double amount);
}
