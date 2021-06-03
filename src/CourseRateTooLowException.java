public class CourseRateTooLowException extends RateException{
    private String Message;

    @Override
    public String getMessage() {
        return Message;
    }
}
