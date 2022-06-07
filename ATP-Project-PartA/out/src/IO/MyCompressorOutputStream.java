package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class MyCompressorOutputStream extends OutputStream {

    OutputStream _out;

    public MyCompressorOutputStream(OutputStream out) {
        _out = out;
    }

    @Override
    public void write(int b) throws IOException {
    }

    public void write(byte[] b) throws IOException {

        _out.write(b[0]);
        _out.write(b[1]);
        _out.write(b[2]);
        _out.write(b[3]);

        int count=0;
        int index=3;
        int res=0;
        int count1=0;
        String binaryString ="";
        while(index<b.length-8){
            if(count == 8 || index==b.length-8-1 )
            {
                if(count==b.length-8-1 || count <8)
                {
                    char a = binaryString.charAt(0);
                    byte by = (byte) Character.getNumericValue(a);
                    int size = 2+by;
                    _out.write(size);
                }
                else {
                    char a = binaryString.charAt(0);
                    byte by = (byte) Character.getNumericValue(a);
                    _out.write(by);
                }
                //int decimal = Integer.parseInt(binaryString,2);
                for(int i=binaryString.length()-1;i>0;i--) {
                    char aa = binaryString.charAt(i);
                    byte by = (byte) Character.getNumericValue(aa);
                    if(by ==1)
                    {
                        res += Math.pow(2, count1);
                    }
                    count1++;
                }
                _out.write(Integer.parseInt(binaryString,2));
                String str1 = Integer.toBinaryString(res);
                count=0;
                binaryString="";
            }
            binaryString += b[++index];
            count++;

        }
        _out.write(b[index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
        _out.write(b[++index]);
    }
}



