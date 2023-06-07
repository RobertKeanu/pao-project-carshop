package exceptions;

public class FirstException extends Exception {
    private int exceptionCode;
    private String exceptionMessage;
    public FirstException(int exceptionCode,String exceptionMessage)
    {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
    public int getException(){
        return exceptionCode;
    }
    public String getExceptionMessage()
    {
        return exceptionMessage;
    }
}
