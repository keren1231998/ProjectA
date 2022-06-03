package IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleDecompressorInputStream extends InputStream
{
    InputStream in ;

    public SimpleDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
