package Pattern.Singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * @desc 容器管理单例
 * @author wjl
 * @date 2018/7/27 0027
 */
public class SingletonManager {
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private SingletonManager() {
    }

    public static void regsiterService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}
