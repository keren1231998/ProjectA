package IO;

import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class MyDecompressorInputStream extends InputStream {

    InputStream _in;

    public MyDecompressorInputStream(InputStream in){_in = in;}


    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        ByteArrayOutputStream barr = new ByteArrayOutputStream();

        boolean flag =true;
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
        String str1="";
        //int i=0,count;
        while(barr.size() < row*column+4 )
        {
            int start =_in.read();
            int num = _in.read();

            str1 = Integer.toBinaryString(num);
//            if(start ==0 & size-str1.length() !=0 ){fixZER(size-str1.length(),barr);}
            int size = str1.length();
            if(start ==0 & 8-str1.length() !=0 ){fixZER(8-str1.length(),barr);}
            if(start ==2 && barr.size()+size != row*column+4 )
            {fixZER((row*column+4)-(barr.size()+size) ,barr);}
            for(int i=0; i<str1.length();i++)
            {
                char c = str1.charAt(i);
                int num1 = Character.getNumericValue(c);
                barr.write((byte)num1);
            }
            if(start ==1 & 8-str1.length() !=0 ){fixZER(8-str1.length(),barr);}
            if(start ==3 && barr.size() != row*column+4 )
            {fixZER((row*column+4)-barr.size() ,barr);}
        }

        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        barr.write(_in.read());
        barr.write(_in.read());

        ;
        byte[] targetArray = barr.toByteArray();
        int t = targetArray.length;
        int t1 = b.length;

        for(int k=0; k<targetArray.length; k++)
            b[k] = targetArray[k];
        return 1;
    }

    public void fixZER(int zer,ByteArrayOutputStream barr  )
    {
        for(int i=0;i<zer;i++)
            barr.write(0);
    }
}

