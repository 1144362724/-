package text;

public class 对象比较 {

   public static void main(String [] args){
       Person a1 = new Person("三",22);
       Person a2 = new Person("三",22);
       if(a1.compare(a2)){
           System.out.println("对象相等");
       }else {
           System.out.println("不等");
       }
   }
}
class Person{
    private String name;//名字
    private int age;//年龄


    public   Person(String name , int age){
        this.name = name;
        this.age = age;
    }
    public boolean compare(Person pon){
        if(this.name.equals(pon.name)&&this.age == pon.age){
            return true;
        }if(pon == this){
            return true;
        }
        return false;
    }
}
