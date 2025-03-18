package test1;

/**
 * @Author JianZJ
 * @Date 2025/3/18 17:30
 */

public class Test {

    public static void main(String[] args) {
        Exercise exercise = new Exercise(0, 101);
        exercise.formateAndDisplayExercise();

        System.out.println();

        exercise = new Exercise(1, 102);
        exercise.formateAndDisplayExercise();

        System.out.println();

        exercise = new Exercise(2, 13);
        exercise.formateAndDisplayExercise();
    }

}
