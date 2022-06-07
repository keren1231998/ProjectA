package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class SimpleCompressorOutputStream extends OutputStream {

    int countOne =0;
    int countZER=0;
    boolean flagZER=false;
    boolean flagONE = false;
    OutputStream _out;

    public SimpleCompressorOutputStream(OutputStream out){_out = out;}
    @Override
    public void write(int b) throws IOException {

    }

    public void write(byte[] b) throws IOException {


        _out.write(b[0]);
        _out.write(b[1]);
        _out.write(b[2]);
        _out.write(b[3]);
        int index;

        for(index=4;index<b.length-8;index++)
        {
            if(b[index] ==0 & flagZER == false)
            {
                if(flagONE == true){
                    if(countOne > 255)
                    {

                        check255(_out,countOne);
                    }
                    else{_out.write(countOne);}
                    countOne=0;
                    flagONE = false;
                }
                flagZER = true; countZER++;

            }
            else if (b[index] ==0 & flagZER == true)
            {countZER ++;}
            else if(b[index] ==1 & flagONE==false )
            {
                if( index==2){ _out.write(0);}
                else if(flagZER == true){
                    if(countZER > 255)
                    {
                        check255(_out,countZER);
                    }
                    else{_out.write(countZER);}
                    countZER=0;
                    flagZER = false;
                }
                flagONE = true; countOne++;

            }
            else if(b[index] ==1 & flagONE == true)
            {countOne++;}
        }

        if(flagZER == true)
        {
            if(countZER > 255)
            {
                check255(_out,countZER);
            }
            else{_out.write(countZER);}
        }

        else if(flagONE == true){
            if(countOne > 255)
            {

                check255(_out,countOne);
            }
            else{_out.write(countOne);}
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
    public void check255(OutputStream _out,int num) throws IOException {
        int reminder = num/255;
        for(int i=0; i<reminder;i++){
            _out.write(255);
            _out.write(0);
        }
        int temp = num-255*reminder;
        if(temp!=0)
            _out.write(temp);
    }

}
