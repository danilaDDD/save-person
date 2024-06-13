package exception;

import java.io.IOException;

public class ParsePersonException extends IOException {
    public ParsePersonException(String s) {
        super(s);
    }
}
