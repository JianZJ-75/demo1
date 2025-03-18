package test1;

/**
 * @Author JianZJ
 * @Date 2025/3/18 16:25
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 习题
 */
public class Exercise {

    // 算式集合
    private List<Equation> equations = new ArrayList<>();
    // 习题类型
    private int type;

    private static final String[] TYPE_NAMES = {"综合练习:", "加法练习:", "减法练习:"};

    public Exercise(int type, int n) {
        this.type = type;
        switch (type) {
            case 0:
                generateExerciseOfEquations(n);
                break;
            case 1:
                generateExerciseOfAdditionEquations(n);
                break;
            case 2:
                generateExerciseOfSubstractionEquations(n);
        }
    }

    /**
     * 生成综合练习
     * @param n
     */
    private void generateExerciseOfEquations(int n) {
        for (int i = 0; i < n; i++) {
            if ((int) (Math.random() * 2) == 1) {
                generateExerciseOfAdditionEquations(1);
            } else {
                generateExerciseOfSubstractionEquations(1);
            }
        }
    }

    /**
     * 生成唯一算式
     * @param type
     * @return
     */
    private Equation generateUniqueEquation(int type) {
        Equation tmp = new Equation(type);
        while (true) {
            if (!occursIn(tmp)) {
                return tmp;
            }
            tmp = new Equation(type);
        }
    }

    /**
     * 生成加法练习
     * @param n
     */
    private void generateExerciseOfAdditionEquations(int n) {
        for (int i = 0; i < n; i++) {
            equations.add(generateUniqueEquation(1));
        }
    }

    /**
     * 生成减法练习
     * @param n
     */
    private void generateExerciseOfSubstractionEquations(int n) {
        for (int i = 0; i < n; i++) {
            equations.add(generateUniqueEquation(2));
        }
    }

    /**
     * 格式化并显示练习
     */
    public void formateAndDisplayExercise() {
        System.out.println(TYPE_NAMES[type]);
        for (int i = 0; i < equations.size(); i++) {
            if (i % 10 == 0) {
                int l = i + 1, r = Math.min(i + 10, equations.size());
                System.out.print("\n题目" + l + "~" + r + ":\t");
            }
            System.out.print(equations.get(i).asString());
        }
    }

    /**
     * 判断是否包含某个方程
     * @param equation
     * @return
     */
    public boolean occursIn(Equation equation) {
        for (Equation x : equations) {
            if (x.isEqual(equation)) {
                return true;
            }
        }
        return false;
    }

}
