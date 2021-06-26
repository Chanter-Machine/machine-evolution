package io.bio;

import java.io.*;


/**
 * https://blog.csdn.net/zhaoyanjun6/article/details/54894451 这个说清了为什么有了InputStream的子类FileInputSteam
 * 还需要BuffereredInputStream
 *
 * https://www.cnblogs.com/redick/p/6644594.html 这个说明了InputStream -> InputStreamReader ->BufferedReader
 *
 * https://blog.csdn.net/yczz/article/details/38761237
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis=new FileInputStream("d://desktop//test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
//        ObjectInputStream objectreader=null;
        try {
            InputStreamReader isr=new InputStreamReader(fis,"utf8");
            BufferedReader br=new BufferedReader(isr);

            String line;
            while((line=br.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
