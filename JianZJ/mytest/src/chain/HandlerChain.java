package chain;

/**
 * @Author JianZJ
 * @Date 2025/4/10 15:24
 */
public interface HandlerChain {

    void handler(Long id);

    String mark();

    int order();

}