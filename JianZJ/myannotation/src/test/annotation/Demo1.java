package test.annotation;

/**
 * @Author JianZJ
 * @Date 2024/7/2 18:20
 */
@Test4
@Test1(aaa = "zj", ccc = {"hello", "hi"})
public class Demo1 {
    @Test2("aaa")
    public void aaa() {

    }

    @Test2(value = "aaa")
    public void bbb() {

    }
}