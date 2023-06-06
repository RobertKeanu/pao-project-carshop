package Exceptions;

public class SecondException extends Exception{
    private int exceptionCode;
    private String exceptionMessage;
    public SecondException(int exceptionCode,String exceptionMessage)
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
