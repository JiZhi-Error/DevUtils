package dev.engine.compress;

/**
 * detail: Image Compress Engine
 * @author Ttt
 */
public final class DevCompressEngine {

    private DevCompressEngine() {
    }

    private static ICompressEngine sEngine;

    /**
     * 获取 Compress Engine
     * @return {@link ICompressEngine}
     */
    public static ICompressEngine getEngine() {
        return sEngine;
    }

    /**
     * 设置 Compress Engine
     * @param engine {@link ICompressEngine}
     */
    public static void setEngine(final ICompressEngine engine) {
        DevCompressEngine.sEngine = engine;
    }
}