package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo {


    public static void main(String[] args)throws Exception {

        //获取类上的注解
        Class<AnotationDemo> clazz = AnotationDemo.class;
        MyAnnotation annotationNoClass =  clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationNoClass.getValue());


        //获取属性变量上的注解
        Field name = clazz.getField("name");
        MyAnnotation annotationNoField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationNoField.getValue());

        //获取hello方法变量上的注解
        Method hello = clazz.getMethod("hello");
        MyAnnotation annotationOnMethod = hello.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.getValue());

        //获取defaultMethod方法变量上的注解
        Method defaultMethod = clazz.getMethod("defaultMethod");
        MyAnnotation annotationDefaultMethod = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotationDefaultMethod.getValue());

    }
}
