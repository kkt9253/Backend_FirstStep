package ch9;

public class _03_WrapperClass {
    public static void main(String[] args) {
        Integer i = 123;
        Double d = 1.0;
        Character c = 'A';

        System.out.println(i);
        System.out.println(d);
        System.out.println(c);

        System.out.println("------------------------");

        System.out.println(i.intValue());
        System.out.println(d.intValue());
        System.out.println(c.charValue());

        System.out.println("------------------------");

        String s = d.toString();
        System.out.println(s);
    }
}
