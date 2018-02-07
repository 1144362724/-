package file;

import java.io.*;
import java.util.Scanner;

public class DaYinLiu  {
    public static void main (String [] args) throws IOException{
        String name = "fack ";//
        int age= 20;//
        double trl = 213.19822;
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("D:"+File.separator+"A"+File.separator+"ub.txt")));
        printWriter.print("what fick");
        printWriter.println(438);
        printWriter.println(0.127);

        printWriter.printf("%s,%d,%3.2f",name,age,trl);
        printWriter.close();
        printWriter.flush();
        //打印流解决OutputStream缺陷
        //BufferedReader解决的是InputStream缺陷
        //Scanner解决BufferedReader的缺陷
        Scanner scan = new Scanner(new FileInputStream(new File("D:"+File.separator+"A"+File.separator+"ub.txt")));
        scan.useDelimiter("\n");//自定义分隔符
        while (scan.hasNext()){
            System.out.println("【内容为:】"+ scan.next());
        }
        scan.close();





    }
}
