package io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    //非直接缓冲区 完成文件复制
    public void test1(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }

    //利用直接缓冲区完成文件的复制
    public void test2() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.CREATE_NEW, StandardOpenOption.READ,StandardOpenOption.WRITE);
            //RAM mapping file
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //channel to channel
    public void test3() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.CREATE_NEW, StandardOpenOption.READ,StandardOpenOption.WRITE);

            inChannel.transferTo(0, inChannel.size(), outChannel);

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void test4() {
        Charset charset = Charset.forName("GBK");
        CharsetEncoder ce = charset.newEncoder();

        CharBuffer cb = CharBuffer.allocate(1024);
        try {
            ce.encode(cb);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }
}
