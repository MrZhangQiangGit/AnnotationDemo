package annotation;

import java.math.BigDecimal;

@MyAnnotation(getValue = "Annotation on class")
public class AnotationDemo {

    @MyAnnotation(getValue = "Annotation on filed")
    public String name;

    @MyAnnotation(getValue = "Annotation on method")
    public void hello(){}

    @MyAnnotation
    public void defaultMethod(){}

    public static void main(String[] args) throws Exception{

    long mis =0;
    int intNum = Integer.valueOf(new BigDecimal(11).toString());
        mis = (long)intNum;
    System.out.println(mis);




    }

}
