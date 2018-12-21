package test;

/**
 * @ClassName test.test1
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 15:59
 * @Version 1.0
 **/
public class test1  extends  test {
    @Override
    public void findO() {

    }
    public void a(){
        String a =new String ("2345");
        String b ="2345";
        String c ="2345";
        int i = System.identityHashCode(a);
        int i1 = System.identityHashCode(b);
        int i2 = System.identityHashCode(c);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(a==c);
        System.out.println(b==c);
        System.out.println(a.equals(c));
        System.out.println(c.equals(b));
        System.out.println("====================================================");
        UserA  userQ1 =new UserA("123","456");
        UserA  userQ2 =new  UserA("123123","456");
        UserA  userQ3=new  UserA("123","456");
        System.out.println(System.identityHashCode(userQ1));
        System.out.println(System.identityHashCode(userQ2));
        System.out.println(System.identityHashCode(userQ3));
        System.out.println(userQ1==userQ2);
        System.out.println(userQ1.equals(userQ2));
        System.out.println(userQ1.equals(userQ3));
    }
/*\/*/
    public static void b1(UserA a ){
        a.setPassword("qwe");
        a.setUserName("ewq");
//        a=10;
        System.out.println(a);
    }
    public static void b2(){
        UserA a = new UserA("123", "321");
//        int a =0;
        System.out.println(a);
        b1(a);
        System.out.println(a);
    }
/*/\*/


    public static void main(String[] args) {
        b2();
    }
}
