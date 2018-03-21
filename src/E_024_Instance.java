/**
 * 单例
 */
public class E_024_Instance {

    private static volatile E_024_Instance instance;

    private E_024_Instance() {
    }

    public static E_024_Instance getInstance() {
        if (instance == null) {
            synchronized (E_024_Instance.class) {
                if (instance == null) {
                    instance = new E_024_Instance();
                }
            }
        }
        return instance;
    }
}
