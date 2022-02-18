package afkt.project.feature.ui_effect.recy_adapter.pager_snap

import afkt.project.R
import afkt.project.databinding.AdapterPagerSnapBinding
import afkt.project.model.bean.ItemBean
import afkt.project.utils.ProjectUtils
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import dev.adapter.DevDataAdapter
import dev.base.adapter.DevBaseViewDataBindingVH
import dev.base.adapter.newDataBindingViewHolder
import dev.engine.DevEngine

/**
 * detail: RecyclerView ViewPager 效果 Adapter
 * @author Ttt
 */
class PagerSnapAdapter(data: List<ItemBean>) : DevDataAdapter<ItemBean, DevBaseViewDataBindingVH<AdapterPagerSnapBinding>>() {

    init {
        setDataList(data, false)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DevBaseViewDataBindingVH<AdapterPagerSnapBinding> {
        return newDataBindingViewHolder(parent, R.layout.adapter_pager_snap)
    }

    override fun onBindViewHolder(
        holder: DevBaseViewDataBindingVH<AdapterPagerSnapBinding>,
        position: Int
    ) {
//        holder.binding.setVariable(afkt.project.BR.item, getDataItem(position))
        holder.binding.item = getDataItem(position)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImageUrl(
            view: ImageView?,
            imageUrl: String?
        ) {
            DevEngine.getImage()?.display(
                view, imageUrl,
                ProjectUtils.roundConfig10
            )
        }
    }
}