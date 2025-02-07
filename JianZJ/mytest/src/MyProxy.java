import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author JianZJ
 * @Date 2025/1/26 1:15
 */

class MyInvocationHandler implements InvocationHandler {

    private Animals target;

    public MyInvocationHandler(Animals target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理...");
        return method.invoke(target, args);
    }
}

interface Animals {
    void eat();
}

class Cat implements Animals {
    public void eat() {
        System.out.println("正在吃猫粮...");
    }
}

class Dog {
    public void sleep() {
        System.out.println("正在睡觉...");
    }
}

public class MyProxy {

    public static void main(String[] args) {
        Animals animals = (Animals) Proxy.newProxyInstance(
                Cat.class.getClassLoader(),
                new Class[]{Animals.class},
                new MyInvocationHandler(new Cat())
        );
        animals.eat();
    }

}