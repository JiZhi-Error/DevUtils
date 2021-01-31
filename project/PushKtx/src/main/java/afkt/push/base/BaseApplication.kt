package afkt.push.base

import androidx.multidex.MultiDexApplication
import dev.DevUtils
import dev.base.BuildConfig
import dev.utils.app.logger.DevLogger
import dev.utils.app.logger.LogConfig
import dev.utils.app.logger.LogLevel

class BaseApplication : MultiDexApplication() {

    private val TAG = "PushKtx_TAG"

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            // 初始化 Logger 配置
            DevLogger.init(
                LogConfig()
                    .logLevel(LogLevel.DEBUG)
                    .tag(TAG)
                    .sortLog(true)
                    .methodCount(0)
            )
            // 打开 lib 内部日志 - 线上环境, 不调用方法
            DevUtils.openLog()
            DevUtils.openDebug()
        }
    }
}