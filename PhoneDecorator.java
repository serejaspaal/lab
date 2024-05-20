class PhoneDecorator extends Phone {
    protected Phone decoratedPhone;

    public PhoneDecorator(Phone phone) {
        super(phone.getNumber(), phone.getBalance(), phone.getCallProbability());
        this.decoratedPhone = phone;
    }

    @Override
    public boolean call() {
        return decoratedPhone.call();
    }

    @Override
    public boolean answer() {
        return decoratedPhone.answer();
    }

    @Override
    public boolean endCall() {
        return decoratedPhone.endCall();
    }

    @Override
    public double getBalance() {
        return decoratedPhone.getBalance();
    }

    @Override
    public void recharge(double amount) {
        decoratedPhone.recharge(amount);
    }

    public void rechargeViaPaymentGateway(PaymentGateway paymentGateway, double amount) {
        paymentGateway.makePayment(amount);
        this.recharge(amount);
    }
}
