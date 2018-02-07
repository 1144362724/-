package file;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *  四舍五入
 * num 参数
 * scale 保留位数
 */

class MyMath{
    public static double round(double num,int scale){
        return Math.round(num * Math.pow(10,scale))/Math.pow(10,scale);
    }
}

public class FileA {
     public static void main(String [] args) throws IOException {
        File file = new File("D:"+File.separator+"A"+File.separator+ "my_imag.jpg");
        File fileA = new File("D:"+File.separator);
         File fileB = new File("D:"+File.separator+"A"+File.separator+ "my_image.txt");
         if(!file.getParentFile().exists())//判断父目录是否存在
        {
            file.getParentFile().mkdir();//创建父文件
            fileB.getParentFile().mkdirs();//创建父文件B
        }
        //**********************************添加文件类容*******************************************
        //OutputStream是一个抽象类需要实例化
         OutputStream output = new FileOutputStream(fileB);//默认覆盖，添加内容true
         //Writer out = new OutputStreamWriter(output);//字节转字符
         String msg = "www.baidu.com"; // \r\n   换行
         output.write(msg.getBytes());
         //out.write(msg);
        // output.write(msg.getBytes(),0,3);//加 0，3 部分输出 ——》常用
         output.close();
         output.flush();//清空缓存




//*************************************************************************************
        /*  Boolean
         *  file.isFile();//判断路径是否是文件
         *  file.isDirectory();//判断路径是否是路径
         *  file.length() //文件大小
         *
         */
        if(fileA.isDirectory()&&fileA.exists()){
            File result[] = fileA.listFiles();
            System.out.println("************************开始 - 输出文件夹信息************************");
            for (Object i : result) {
                System.out.println(i);
            }
            System.out.println("************************结束************************");
        }

        if(file.exists() &&  file.isFile()){//文件是否存在
          //  file.delete();//删除
            System.out.println("*************************开始--文件大小***********************");
            System.out.println("文件大小："+MyMath.round((file.length()/(double)1024/1024),2));
            System.out.println("*************************—修改时间—***********************");
            System.out.println("最后一次修改时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new Date(file.lastModified())));
            System.out.println("*************************—读取—***********************");
            InputStream input = new FileInputStream(fileB);
            byte data[] = new byte[1024];
            int len = input.read(data);
            String str = new String(data,0,len);//限制长度不然内存会添加1024字节内容
            System.out.println("读取类容： { "+ str +"}");
            System.out.println("*************************结束***********************");
        }else {
            file.createNewFile();//创建文件 必有异常
        }
    }
}
//字节（原生）￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥
//write （字节全部输出byte[]）
//OutputStream 输出
//read()
//InputStream  输入
//字符 (经过处理)
//Writer  输出
//Reader  输入
// OutputStreamWriter;输出 字节转字符
// InputStreamReader;输入


