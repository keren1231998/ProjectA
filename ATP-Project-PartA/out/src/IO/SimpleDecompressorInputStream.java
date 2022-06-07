package IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class SimpleDecompressorInputStream extends InputStream {

    InputStream _in;

    public SimpleDecompressorInputStream(InputStream in){_in = in;}


    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {

        ByteArrayOutputStream barr = new ByteArrayOutputStream();

        int temp = _in.read();
        barr.write(temp);
        int tem1 = _in.read();
        barr.write(tem1);
        int column = ((tem1 & 0xff) << 8) | (temp & 0xff);
        temp = _in.read();
        barr.write(temp);
        tem1 = _in.read();
        barr.write(tem1);
        int row = ((tem1 & 0xff) << 8) | (temp & 0xff);

        int i=0,count;
        while(barr.size() < row*column+4 )
        {
            if(i%2==0){
                count = _in.read();
                for(int j=0; j<count;j++)
                    barr.write(0);
            }
            else{
                count = _in.read();
                for(int j=0; j<count;j++)
                    barr.write(1);

            }
            i++;
        }


        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        byte[] targetArray = barr.toByteArray();
        boolean flag = true ? targetArray.length == b.length : false;
        for(int k=0; k<targetArray.length; k++)
            b[k] = targetArray[k];
        return 1;
    }
}
