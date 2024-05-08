package feed;

/**
 * @Author JianZJ
 * @Date 2024/5/8 23:15
 */
public class HuskyDog extends Dog {

    public HuskyDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做" + getName() + "的, " + getAge() + "岁的哈士奇, 正在吃骨头, 边吃边拆家");
    }
}
