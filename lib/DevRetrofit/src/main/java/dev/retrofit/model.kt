package dev.retrofit

// ====================
// = 数据模型、接口汇总类 =
// ====================

/**
 * detail: DevRetrofit 封装 Base 类
 * @author Ttt
 * 防止污染引用项目 BaseXxx 类
 * 使用 Base 进行包装
 */
class Base private constructor() {

    /**
     * detail: 请求响应解析类 ( 接口 )
     * @author Ttt
     * 定义为接口是为了解决不同公司后端字段不一致情况
     * 如何解决:
     * 接口定义通用方法, 自行编写 Custom Response 类以及后台定义的字段
     * 并实现 Base.Response 解析类, 在对应通用方法返回所属的自定义字段
     */
    interface Response<T> {

        fun getData(): T?

        fun getCode(): String?

        fun getMessage(): String?

        fun isSuccess(): Boolean
    }

    /**
     * detail: 请求结果包装类
     * @author Ttt
     */
    class Result<T, R : Response<T>> private constructor(
        private val response: R?,
        // 不为 null 表示出错抛出异常
        private val error: Throwable?,
        // 额外携带参数 ( 扩展使用 )
        private var params: Any? = null
    ) { // : Response<T>

        // ===========
        // = get/set =
        // ===========

        fun getResponse(): R? {
            return response
        }

        fun getError(): Throwable? {
            return error
        }

        fun isError(): Boolean {
            return error != null
        }

        fun getErrorCode(): ErrorCode {
            return error.errorCode()
        }

        // =

        fun getParams(): Any? {
            return params
        }

        fun setParams(params: Any?): Result<T, R> {
            this.params = params
            return this
        }

        // ============
        // = Response =
        // ============

        fun getData(): T? {
            return response?.getData()
        }

        fun getCode(): String? {
            return response?.getCode()
        }

        fun getMessage(): String? {
            return response?.getMessage()
        }

        fun isSuccess(): Boolean {
            return response?.isSuccess() ?: false
        }

        // =========
        // = Build =
        // =========

        class Build<T, R : Response<T>>(
            private var response: R?,
            private var error: Throwable?
        ) {

            fun build(): Result<T, R> {
                return Result(response, error)
            }

            // ===========
            // = get/set =
            // ===========

            fun getResponse(): R? {
                return response
            }

            fun setResponse(response: R?): Build<T, R> {
                this.response = response
                return this
            }

            fun getError(): Throwable? {
                return error
            }

            fun setError(error: Throwable?): Build<T, R> {
                this.error = error
                return this
            }
        }
    }

    /**
     * detail: 错误类型 ( 简单定义 )
     * @author Ttt
     */
    enum class ErrorCode {

        NO_ERROR,

        UNKNOWN,

        PARSE_ERROR,

        NETWORK_ERROR,

        TIMEOUT_ERROR,

        SSL_ERROR
    }
}

// =================
// = Base - 扩展函数 =
// =================

/**
 * 通过 Base.Response 实现类创建 Result.Build 来决定请求结果
 * @receiver R
 * @param error Throwable?
 * @return Base.Result.Build<T, R>
 */
fun <T, R : Base.Response<T>> R?.result(error: Throwable? = null): Base.Result.Build<T, R> {
    return Base.Result.Build(this, error)
}

/**
 * 创建一个空白的 Result.Build 自行传参
 * @param error Throwable?
 * @return Base.Result.Build<T, R>
 */
fun <T, R : Base.Response<T>> resultCreate(error: Throwable? = null): Base.Result.Build<T, R> {
    return Base.Result.Build(null, error)
}

// ==========
// = Notify =
// ==========

/**
 * detail: DevRetrofit 封装 Notify ( Callback ) 类
 * @author Ttt
 * 防止污染引用项目 Callback 类
 * 使用 Notify 来表示当前请求所进行的阶段通知
 */
class Notify private constructor() {

    /**
     * detail: 当前请求每个阶段进行通知
     * @author Ttt
     * 允许继承自定义其他参数
     */
    abstract class Callback<T, P>(
        // 额外携带参数 ( 扩展使用 )
        private var params: P? = null
    ) {

        // ===========
        // = get/set =
        // ===========

        fun getParams(): P? {
            return params
        }

        fun setParams(params: P?): Callback<T, P> {
            this.params = params
            return this
        }

        // ============
        // = abstract =
        // ============

        /**
         * 开始请求
         */
        abstract fun onStart()

        /**
         * 请求异常
         * @param error Throwable?
         */
        abstract fun onError(error: Throwable?)

        /**
         * 请求成功
         * @param data T
         */
        abstract fun onSuccess(data: T?)

        /**
         * 请求结束
         * 不管是 [onError]、[onSuccess] 最终都会触发该结束方法
         */
        abstract fun onFinish()
    }
}