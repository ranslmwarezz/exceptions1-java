package model.exceptions;

public class DomainException extends RuntimeException {
    //private static final long serialUID = 1L;

    public DomainException(String msg){
        super(msg);
    }

}
