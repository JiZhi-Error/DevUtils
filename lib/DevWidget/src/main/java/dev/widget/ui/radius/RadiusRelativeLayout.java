package dev.widget.ui.radius;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import dev.widget.utils.RadiusAttrs;

/**
 * detail: 自定义圆角 RelativeLayout
 * @author Ttt
 * <pre>
 *     区别于 {@link dev.widget.ui.round.RoundDrawable} 属于设置 Drawable
 *     这个是裁剪 View 为圆角效果
 *     <p></p>
 *     app:dev_radius=""
 *     app:dev_radiusLeftTop=""
 *     app:dev_radiusLeftBottom=""
 *     app:dev_radiusRightTop=""
 *     app:dev_radiusRightBottom=""
 *     app:dev_clearRadius=""
 * </pre>
 */
public class RadiusRelativeLayout
        extends RelativeLayout
        implements IRadiusMethod<RadiusRelativeLayout> {

    protected RadiusAttrs mRadiusAttrs;

    public RadiusRelativeLayout(Context context) {
        super(context);
        initAttrs(context, null, 0, 0);
    }

    public RadiusRelativeLayout(
            Context context,
            AttributeSet attrs
    ) {
        super(context, attrs);
        initAttrs(context, attrs, 0, 0);
    }

    public RadiusRelativeLayout(
            Context context,
            AttributeSet attrs,
            int defStyleAttr
    ) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RadiusRelativeLayout(
            Context context,
            AttributeSet attrs,
            int defStyleAttr,
            int defStyleRes
    ) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 初始化
     * @param context      {@link Context}
     * @param attrs        {@link AttributeSet}
     * @param defStyleAttr 默认样式
     * @param defStyleRes  默认样式资源
     */
    private void initAttrs(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes
    ) {
        mRadiusAttrs = new RadiusAttrs(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
    }

    // ============
    // = override =
    // ============

    @Override
    protected void onSizeChanged(
            int w,
            int h,
            int oldw,
            int oldh
    ) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRadiusAttrs.onSizeChanged(w, h);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(mRadiusAttrs.getPath());
        super.draw(canvas);
        canvas.restore();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return mRadiusAttrs.onSaveInstanceState(super.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(mRadiusAttrs.onRestoreInstanceState(state));
        mRadiusAttrs.onSizeChanged(getWidth(), getHeight());
    }

    // =================
    // = IRadiusMethod =
    // =================

    // =============
    // = Operation =
    // =============

    /**
     * 是否清空绘制圆角值
     * @return {@code true} yes, {@code false} no
     */
    @Override
    public boolean isClearRadius() {
        return mRadiusAttrs.isClearRadius();
    }

    /**
     * 设置是否清空绘制圆角值
     * @param clear {@code true} yes, {@code false} no
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setClearRadius(final boolean clear) {
        mRadiusAttrs.setClearRadius(clear);
        return this;
    }

    /**
     * 清空绘制圆角值 ( 默认不进行绘制 )
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout clearRadius() {
        return clearRadius(false);
    }

    /**
     * 清空绘制圆角值
     * @param invalidate 是否进行绘制
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout clearRadius(final boolean invalidate) {
        mRadiusAttrs.clearRadius();
        if (invalidate) postInvalidate();
        return this;
    }

    // ===========
    // = get/set =
    // ===========

    /**
     * 设置圆角值
     * @param radius 圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadius(final float radius) {
        mRadiusAttrs.setRadius(radius);
        postInvalidate();
        return this;
    }

    /**
     * 设置左上圆角值
     * @param radiusLeftTop 左上圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusLeftTop(final float radiusLeftTop) {
        mRadiusAttrs.setRadiusLeftTop(radiusLeftTop);
        postInvalidate();
        return this;
    }

    /**
     * 设置左下圆角值
     * @param radiusLeftBottom 左下圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusLeftBottom(final float radiusLeftBottom) {
        mRadiusAttrs.setRadiusLeftBottom(radiusLeftBottom);
        postInvalidate();
        return this;
    }

    /**
     * 设置右上圆角值
     * @param radiusRightTop 右上圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusRightTop(final float radiusRightTop) {
        mRadiusAttrs.setRadiusRightTop(radiusRightTop);
        postInvalidate();
        return this;
    }

    /**
     * 设置右下圆角值
     * @param radiusRightBottom 右下圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusRightBottom(final float radiusRightBottom) {
        mRadiusAttrs.setRadiusRightBottom(radiusRightBottom);
        postInvalidate();
        return this;
    }

    // =

    /**
     * 设置左上、左下圆角值
     * @param radiusLeft 左边圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusLeft(final float radiusLeft) {
        mRadiusAttrs.setRadiusLeft(radiusLeft);
        postInvalidate();
        return this;
    }

    /**
     * 设置右上、右下圆角值
     * @param radiusRight 右边圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusRight(final float radiusRight) {
        mRadiusAttrs.setRadiusRight(radiusRight);
        postInvalidate();
        return this;
    }

    /**
     * 设置左上、右上圆角值
     * @param radiusTop 上边圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusTop(final float radiusTop) {
        mRadiusAttrs.setRadiusTop(radiusTop);
        postInvalidate();
        return this;
    }

    /**
     * 设置左下、右下圆角值
     * @param radiusBottom 下边圆角值
     * @return {@link RadiusRelativeLayout}
     */
    @Override
    public RadiusRelativeLayout setRadiusBottom(final float radiusBottom) {
        mRadiusAttrs.setRadiusBottom(radiusBottom);
        postInvalidate();
        return this;
    }

    // =

    /**
     * 获取圆角值
     * @return 圆角值
     */
    @Override
    public float getRadius() {
        return mRadiusAttrs.getRadius();
    }

    /**
     * 获取左上圆角值
     * @return 左上圆角值
     */
    @Override
    public float getRadiusLeftTop() {
        return mRadiusAttrs.getRadiusLeftTop();
    }

    /**
     * 获取左下圆角值
     * @return 左下圆角值
     */
    @Override
    public float getRadiusLeftBottom() {
        return mRadiusAttrs.getRadiusLeftBottom();
    }

    /**
     * 获取右上圆角值
     * @return 右上圆角值
     */
    @Override
    public float getRadiusRightTop() {
        return mRadiusAttrs.getRadiusRightTop();
    }

    /**
     * 获取右下圆角值
     * @return 右下圆角值
     */
    @Override
    public float getRadiusRightBottom() {
        return mRadiusAttrs.getRadiusRightBottom();
    }
}