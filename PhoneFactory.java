abstract class PhoneFactory {
    public abstract Phone createPhone(String number, double balance, double callProbability);

    public static PhoneFactory getFactory() {
        return new ConcretePhoneFactory();
    }
}

class ConcretePhoneFactory extends PhoneFactory {
    @Override
    public Phone createPhone(String number, double balance, double callProbability) {
        return new Phone(number, balance, callProbability);
    }
}