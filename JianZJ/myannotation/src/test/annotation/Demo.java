package test.annotation;

/**
 * @Author JianZJ
 * @Date 2024/7/2 18:42
 */
@Test5(value = "zj", bbb = {"hello", "hi"})
public class Demo {
    @Test5(value = "amy", bbb = {"io"})
    public void test1() {

    }
}