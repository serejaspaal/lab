class CallService {
    private static CallService instance;

    private CallService() {}

    public static synchronized CallService createCallService() {
        if (instance == null) {
            instance = new CallService();
        }
        return instance;
    }

    public boolean initiateCall(Phone phone) {
        return phone.call();
    }

    public boolean receiveCall(Phone phone) {
        return phone.answer();
    }

    public boolean terminateCall(Phone phone) {
        return phone.endCall();
    }
}