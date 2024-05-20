class PaymentAdapter implements PaymentGateway {
    private ExternalPaymentSystem externalPaymentSystem;

    public PaymentAdapter(ExternalPaymentSystem externalPaymentSystem) {
        this.externalPaymentSystem = externalPaymentSystem;
    }

    @Override
    public void makePayment(double amount) {
        externalPaymentSystem.pay(amount);
    }
}