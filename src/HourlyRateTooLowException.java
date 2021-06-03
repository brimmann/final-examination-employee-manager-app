public class HourlyRateTooLowException extends RateException {
    private String Message;

    @Override
    public String getMessage() {
        return Message;
    }
}
