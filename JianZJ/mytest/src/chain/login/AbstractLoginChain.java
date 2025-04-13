package chain.login;

import chain.HandlerChain;

/**
 * @Author JianZJ
 * @Date 2025/4/10 15:25
 */
public abstract class AbstractLoginChain implements HandlerChain {

    public String mark() {
        return "login_chain";
    }

}