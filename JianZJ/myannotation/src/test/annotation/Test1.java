package test.annotation;

public @interface Test1 {
    String aaa();
    boolean bbb() default true;
    String[] ccc();
}
