import chain.HandlerChain;
import chain.login.Chain1;
import chain.login.Chain2;

import java.util.*;

public class Main {

    static Map<String, List<HandlerChain>> chains;

    static {
        chains = new HashMap<String, List<HandlerChain>>();
        chains.put("login_chain", new ArrayList<>());
        chains.get("login_chain").add(new Chain1());
        chains.get("login_chain").add(new Chain2());
        chains.get("login_chain").sort(new Comparator<HandlerChain>() {
            @Override
            public int compare(HandlerChain o1, HandlerChain o2) {
                return o1.order() - o2.order();
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("登录...");
        Long id = 1L;
        List<HandlerChain> tmp = chains.get("login_chain");
        for (HandlerChain chain : tmp) {
            chain.handler(id);
        }
    }
}