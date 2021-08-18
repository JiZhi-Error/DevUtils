package dev.engine.http;

import java.util.LinkedHashMap;
import java.util.Map;

import dev.utils.DevFinal;

/**
 * detail: Http Engine
 * @author Ttt
 */
public final class DevHttpEngine {

    private DevHttpEngine() {
    }

    private static final Map<String, IHttpEngine> sEngineMaps = new LinkedHashMap<>();

    /**
     * 获取 Engine
     * @return {@link IHttpEngine}
     */
    public static IHttpEngine getEngine() {
        return getEngine(DevFinal.DEFAULT);
    }

    /**
     * 获取 Engine
     * @param key key
     * @return {@link IHttpEngine}
     */
    public static IHttpEngine getEngine(final String key) {
        return sEngineMaps.get(key);
    }

    /**
     * 设置 Engine
     * @param engine {@link IHttpEngine}
     * @return {@link IHttpEngine}
     */
    public static IHttpEngine setEngine(final IHttpEngine engine) {
        return setEngine(DevFinal.DEFAULT, engine);
    }

    /**
     * 设置 Engine
     * @param key    key
     * @param engine {@link IHttpEngine}
     * @return {@link IHttpEngine}
     */
    public static IHttpEngine setEngine(
            final String key,
            final IHttpEngine engine
    ) {
        sEngineMaps.put(key, engine);
        return engine;
    }

    /**
     * 移除 Engine
     */
    public static void removeEngine() {
        removeEngine(DevFinal.DEFAULT);
    }

    /**
     * 移除 Engine
     * @param key key
     */
    public static void removeEngine(final String key) {
        sEngineMaps.remove(key);
    }

    // ==========
    // = 其他方法 =
    // ==========

    /**
     * 获取 Engine Map
     * @return Engine Map
     */
    public static Map<String, IHttpEngine> getsEngineMaps() {
        return sEngineMaps;
    }

    /**
     * 是否存在 Engine
     * @return {@code true} yes, {@code false} no
     */
    public static boolean contains() {
        return contains(DevFinal.DEFAULT);
    }

    /**
     * 是否存在 Engine
     * @param key key
     * @return {@code true} yes, {@code false} no
     */
    public static boolean contains(final String key) {
        return sEngineMaps.containsKey(key);
    }

    /**
     * 判断 Engine 是否为 null
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isEmpty() {
        return isEmpty(DevFinal.DEFAULT);
    }

    /**
     * 判断 Engine 是否为 null
     * @param key key
     * @return {@code true} yes, {@code false} no
     */
    public static boolean isEmpty(final String key) {
        return getEngine(key) == null;
    }
}