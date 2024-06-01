package afkt.project.feature.dev_widget.view_pager

import afkt.project.R
import afkt.project.base.project.BaseProjectActivity
import afkt.project.base.project.BaseProjectViewModel
import afkt.project.data_model.button.RouterPath
import afkt.project.databinding.ActivityViewPagerBinding
import com.therouter.router.Route
import dev.expand.engine.log.log_dTag
import dev.widget.custom.CustomViewPager.OnDirectionListener

/**
 * detail: ViewPager 滑动监听、控制滑动
 * @author Ttt
 */
@Route(path = RouterPath.DEV_WIDGET.ViewPagerActivity_PATH)
class ViewPagerActivity : BaseProjectActivity<ActivityViewPagerBinding, BaseProjectViewModel>(
    R.layout.activity_view_pager, simple_Agile = {
        if (it is ViewPagerActivity) {
            it.apply {
                val lists = mutableListOf<String>()
                for (i in 0..4) lists.add((i + 1).toString())
                binding.vidVp.adapter = ViewPagerAdapter(lists)
                binding.vidVp.setCurrentItem(lists.size * 100, false)
                binding.vidVp.setOnPageChangeListener(object : OnDirectionListener() {
                    override fun onSlideDirection(
                        left: Boolean,
                        right: Boolean
                    ) {
                        if (left && !right) {
                            TAG.log_dTag(
                                message = "往左滑 - 从右往左"
                            )
                        } else {
                            TAG.log_dTag(
                                message = "往右滑 - 从左往右"
                            )
                        }
                    }

                    override fun onPageSelected(index: Int) {
                        TAG.log_dTag(
                            message = "索引变动: $index"
                        )
                        if (mLeftScroll) {
                            showToast("往左滑 - 从右往左")
                        } else {
                            showToast("往右滑 - 从左往右")
                        }
                    }
                })
                binding.vidAllowBtn.setOnClickListener {
                    binding.vidVp.isSlide = true
                    showToast(true, "已允许滑动")
                }
                binding.vidBanBtn.setOnClickListener {
                    binding.vidVp.isSlide = false
                    showToast(false, "已禁止滑动")
                }
            }
        }
    }
)