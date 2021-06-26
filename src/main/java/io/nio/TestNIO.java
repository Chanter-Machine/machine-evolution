package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

public class TestNIO {


    public void client() throws IOException {
        //1. 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8989));
        // 2. Switch to non-blocking channel
        sChannel.configureBlocking(false);
        // 3.Allocate buffer size
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 4. Send data to server
        buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();
        //5.close
        sChannel.close();
    }

    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //switch to non-blocking mode
        ssChannel.configureBlocking(false);

        //3. bind connection
        ssChannel.bind(new InetSocketAddress(9889));

        //4. Get an selector
        Selector selector = Selector.open();
        // 5.

        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6. 轮询式的获取选择器上已经准备就绪的事件
        while (selector.select() > 0) {
            //获取当前选择器中的注册的选择键
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            //8. 迭代获取
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                if(sk.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    // 11. Switch to non-blocking mode
                    sChannel.configureBlocking(false);
                    // 12. Register to selector
                        sChannel.register(selector, SelectionKey.OP_READ);
                }else if(sk.isReadable()) {
                    // 13. 获取当前选择器“读就绪“状态通道
                    SocketChannel sChannel = (SocketChannel) sk.channel().configureBlocking(false);
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len=sChannel.read(buf))> 0 ) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }

                }

                // cancel selectionKey
                it.remove();
            }
        }
    }
}
