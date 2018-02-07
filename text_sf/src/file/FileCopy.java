package file;


import java.io.*;

/*
 * 文件拷贝
 * 需要判断目标源文件是否存在；
 * 需要判断目标文件父路径是否存在，不存在创建
 * @date 2018/2/3 22:09
 */
class  CopyUtil{
    private  CopyUtil(){} //构造方法私有化
    /**
     * 判断原路径是否存在
     * @author MoGary
     * @date 2018/2/3 22:16
     * @param path 输入源原路径信
     * @return  如果源路径存在返回 true,否则返回 false
     **/
    public static  boolean fileExists(String path) {
        return new File(path).exists();
    }
    /**
     * 根据传入的路径来判断其父路径是否存在，如果不存在则创建
     * @author MoGary
     * @date 2018/2/3 22:36
     * @param path 操作文件的路径
     * @return
     **/
    public static  void createParentDirectory(String path){
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }else {
            file.delete();
        }
    }
    /**
     * 实现文件拷贝
     * @author MoGary
     * @date 2018/2/3 22:50
     * @param   srcpath 源文件路径
     * @param   despath 目标文件路径
     * @return  拷贝完成返回true,否则返回false
     **/
    public static boolean copy(String srcpath,String despath){
        boolean flag = true;
        File inFile = new File(srcpath);
        File outFile = new File(despath);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(inFile);
            output = new FileOutputStream(outFile);
            copyHandle(input,output);
        } catch (IOException e) {
            flag = false;
        }finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.fillInStackTrace();
            }

        }
        return flag;
    }
    /**  
     * 实现具体文件操作
     * @author MoGary  
     * @date 2018/2/3 22:56  
     * @param input  输入流对象
     * @param output  输出流对象
     * @return
     **/
    public static void copyHandle(InputStream input, OutputStream output)throws IOException {
        //InputStream 读取单个字节的方法  int read()
        //OutputStream 读取单个字节的方法  void write(int data)
        int temp = 0;
        byte data[] = new byte[1024];
        long s = System.currentTimeMillis();
        ByteArrayOutputStream  uu = new  ByteArrayOutputStream();//内存缓存
       while (( temp = input.read(data))!=-1){ //read获取字节长度
           output.write(data,0,temp);
       }
       long d = System.currentTimeMillis();
        System.out.println((d-s));
    }
}


public class FileCopy {
    public static void main(String [] args){
          if(args.length !=2){
              System.out.println("错误的执行方式，命令调用：Java Copy 源文件路径 目标文件路径");
              System.exit(1);//系统退出
          }
        if (CopyUtil.fileExists(args[0])) {
              CopyUtil.createParentDirectory(args[1]);
            System.out.println(CopyUtil.copy(args[0],args[1])? "文件拷贝成功":"文件拷贝失败" );
        }else {
            System.out.println("对不起源文件不存在，无法完成拷贝操作");
        }
    }





















}
