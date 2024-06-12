package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/12 19:18
 */
public class Solution_2024_6_12 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int tmp = purchaseAmount / 10;
        if (purchaseAmount % 10 >= 5)
            tmp++;
        return 100 - 10 * tmp;
    }
}