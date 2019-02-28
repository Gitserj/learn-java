package main.lambda;

import java.io.IOException;
import java.io.Reader;

interface MyIOAction {
    boolean ioAction(Reader rd) throws IOException;
}

public class LambdaExceptionDemo {
    double[] vals = {1.0, 2.0, 3.0, 4.0, 5.0};

    MyIOAction myIO = rdr -> {
        int ch = rdr.read();
        return true;
    };
}
