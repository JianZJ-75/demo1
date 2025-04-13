package chain.login;

/**
 * @Author JianZJ
 * @Date 2025/4/10 15:27
 */
public class Chain2 extends AbstractLoginChain {

    @Override
    public void handler(Long id) {
        System.out.println("chain 2验证");
    }

    @Override
    public int order() {
        return 1;
    }
}