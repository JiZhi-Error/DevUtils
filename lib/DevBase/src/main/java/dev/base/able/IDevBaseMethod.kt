package dev.base.able

import android.view.View

/**
 * detail: 基类通用方法
 * @author Ttt
 */
interface IDevBaseMethod {

    /**
     * 初始化顺序 ( 需主动调用 )
     */
    fun initOrder() {
        initView()
        initValue()
        initListener()
        initObserve()
        initOther()
    }

    /**
     * 预加载方法 ( 需主动调用, 预留可选 )
     * 例:
     * Activity : [preLoad] ( onCreate ) => [initOrder] ( onCreate )
     * Fragment : [preLoad] ( onCreateView ) => [initOrder] ( onViewCreated )
     */
    fun preLoad() {}

    // ============
    // = 初始化方法 =
    // ============

    /**
     * 初始化 View
     */
    fun initView()

    /**
     * 初始化参数、配置
     */
    fun initValue()

    /**
     * 初始化事件
     */
    fun initListener()

    /**
     * 初始化观察事件
     */
    fun initObserve()

    /**
     * 初始化其他操作
     */
    fun initOther()

    // ==============
    // = 触发前后方法 =
    // ==============

    /**
     * Activity onCreate 创建之前触发
     */
    fun activityOnCreateBefore() {}

    /**
     * Inflate View 之前触发
     */
    fun beforeInflateView() {}

    /**
     * Inflate View 之后触发
     */
    fun afterInflateView(parentView: View) {}
}