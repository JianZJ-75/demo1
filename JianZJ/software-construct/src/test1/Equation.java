package test1;

/**
 * @Author JianZJ
 * @Date 2025/3/18 16:25
 */

/**
 *  算式
 *      运算数和运算结果取值范围为[0,100];
 */
public class Equation {

    // 运算数字 最后一个为结果
    private int[] nums = new int[3];
    // 运算符 true+ false-
    private boolean operator;

    public Equation(int type) {
        generateEquation(type);
    }

    /**
     * 生成通用方程
     * @param type
     */
    private void generateEquation(int type) {
        operator = type == 1 ? true : false;
        if (type == 1) {
            generateAdditionEquation();
        } else {
            generateSubstractionEquation();
        }
    }

    /**
     * 生成加法方程
     */
    private void generateAdditionEquation() {
        nums[0] = (int) (Math.random() * 101);
        nums[1] = (int) (Math.random() * (101 - nums[0]));
        calculateAdditionEquation();
    }

    /**
     * 生成减法方程
     */
    private void generateSubstractionEquation() {
        nums[0] = (int) (Math.random() * 101);
        nums[1] = (int) (Math.random() * (nums[0] + 1));
        calculateSubstractionEquation();
    }

    /**
     * 计算加法方程
     */
    private void calculateAdditionEquation() {
        nums[2] = nums[0] + nums[1];
    }

    /**
     * 计算减法方程
     */
    private void calculateSubstractionEquation() {
        nums[2] = nums[0] - nums[1];
    }

    /**
     * 方程转字符串
     * @return
     */
    public String asString() {
        return String.format("%-15s", nums[0] + (operator == true ? " + " : " - ") + nums[1] + " = " + nums[2]);
    }

    /**
     * 判断两个方程是否相等
     * @param equation
     * @return
     */
    public boolean isEqual(Equation equation) {
        if (operator != equation.operator) {
            return false;
        }
        if (nums[0] == equation.nums[0] && nums[1] == equation.nums[1] ||
            nums[0] == equation.nums[1] && nums[1] == equation.nums[0]) {
            return true;
        }
        return false;
    }

}
