package exception;

import java.io.IOException;

public class SavePersonException extends IOException {
    public SavePersonException(String message) {
        super(message);
    }

    public SavePersonException(Throwable cause) {
        super(cause);
    }
}
