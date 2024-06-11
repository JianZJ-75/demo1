package test.test2;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:00
 */
public class AgeOutOfBoundsException extends RuntimeException{
    public AgeOutOfBoundsException() {
        super();
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}