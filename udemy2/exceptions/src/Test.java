import java.io.IOException;
import java.text.ParseException;

public class Test {

    public void run() throws IOException, ParseException {
        //you can throw any number of possible exceptions
        //throw new IOException();
        throw new ParseException("Error in command list", 2);
    }
}
