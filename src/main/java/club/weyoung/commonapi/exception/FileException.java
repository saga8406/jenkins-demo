///:FileException.java
package club.weyoung.commonapi.exception;

/**
 * @author icechen1219
 * @date 2019/05/15
 */
public class FileException extends RuntimeException{
    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
///:FileException.java
