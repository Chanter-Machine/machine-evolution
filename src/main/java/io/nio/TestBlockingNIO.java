package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 三个核心：
 * 1. Channel 负责连接
 * 2. SelectableChannel
 *      |== SocketChannel
 *      |-- ServerSocketChannel
 *      |-- DatagramChannle
 *
 *      |-- Pipe.SInkChannel
 *      |-- Pipe.SOurceChannel
 */

public class TestBlockingNIO {

    public void client() {
        FileChannel inChannel = null;
        SocketChannel sChannel = null;
        try {
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

            inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
            // 2. 分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //3. 读取本地文件并发到服务端
            while(inChannel.read(buf)!= -1) {
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                sChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.CREATE_NEW, StandardOpenOption.READ,StandardOpenOption.WRITE);

        //绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        // 获取客户端连接通道
        SocketChannel sChannel = ssChannel.accept();

        //分配缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //接受客户端数据,并保存到本地
        while (sChannel.read(buf) !=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //close
        sChannel.close();
        outChannel.close();
        ssChannel.close();

    }
}
