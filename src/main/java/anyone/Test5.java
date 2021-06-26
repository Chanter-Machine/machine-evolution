package anyone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {
    public static void main(String[] args) {


        Map<String, String>fileContents = getFilesDatas("D:\\迅雷下载\\files\\files");

        for(Map.Entry<String, String> entry : fileContents.entrySet()) {
            String content = entry.getValue();
            String pattern1 = "^.*database.*";
            String pattern2 = "^.*java.*";

            Pattern p1 =Pattern.compile("^.*database.*",Pattern.MULTILINE);
            Pattern p2 =Pattern.compile("^.*java.*",Pattern.MULTILINE);

//            String newContent = content.replace("\n", "");
            Matcher m1 = p1.matcher(content);
            Matcher m2 = p2.matcher(content);

//            boolean isMatch1 = Pattern.matches(pattern1, newContent);
//            boolean isMatch2 = Pattern.matches(pattern2, newContent);
            if(m1.find() && m2.find()) {
                System.out.println(entry.getKey());
            }

        }
    }

    /**
     * 获取某文件夹下的文件名和文件内容,存入map集合中
     * @param filePath 需要获取的文件的 路径
     * @return 返回存储文件名和文件内容的map集合
     */
    public static Map<String, String> getFilesDatas(String filePath){
        Map<String, String> files = new HashMap<>();
        File file = new File(filePath); //需要获取的文件的路径
        String[] fileNameLists = file.list(); //存储文件名的String数组
        File[] filePathLists = file.listFiles(); //存储文件路径的String数组
        for(int i=0;i<filePathLists.length;i++){
            if(filePathLists[i].isFile()){
                try {//读取指定文件路径下的文件内容
                    String fileDatas = readFile(filePathLists[i]);
                    //把文件名作为key,文件内容为value 存储在map中
                    files.put(fileNameLists[i], fileDatas);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return files;
    }

    /**
     * 读取指定目录下的文件
     * @param path 文件的路径
     * @return 文件内容
     * @throws IOException
     */
    public static String readFile(File path) throws IOException {
        //创建一个输入流对象
        InputStream is = new FileInputStream(path);
        //定义一个缓冲区
        byte[] bytes = new byte[2048];// 1kb
        //通过输入流使用read方法读取数据
        int len = is.read(bytes);
        //System.out.println("字节数:"+len);
        String str = null;
        while(len!=-1){
            //把数据转换为字符串
            str = new String(bytes, 0, len);
            //System.out.println(str);
            //继续进行读取
            len = is.read(bytes);
        }
        //释放资源
        is.close();
        return str.toLowerCase();
    }
}
