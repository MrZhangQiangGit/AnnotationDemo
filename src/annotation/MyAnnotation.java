package annotation;

import java.lang.annotation.*;

//@Documented
//@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
 public  @interface MyAnnotation {



    String getValue()default "no description";


}
