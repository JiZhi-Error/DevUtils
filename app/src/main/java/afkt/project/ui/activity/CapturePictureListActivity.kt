package afkt.project.ui.activity

import afkt.project.R
import afkt.project.base.app.BaseActivity
import afkt.project.base.config.PathConfig
import afkt.project.databinding.ActivityCapturePictureListBinding
import afkt.project.databinding.AdapterCapturePictureBinding
import afkt.project.model.bean.AdapterBean
import afkt.project.model.bean.AdapterBean.Companion.newAdapterBeanList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import dev.base.widget.BaseTextView
import dev.utils.app.CapturePictureUtils
import dev.utils.app.ResourceUtils
import dev.utils.app.helper.QuickHelper
import dev.utils.app.helper.ViewHelper
import dev.utils.app.image.ImageUtils

/**
 * detail: CapturePictureUtils ListView 截图
 * @author Ttt
 */
class CapturePictureListActivity : BaseActivity<ActivityCapturePictureListBinding>() {

    override fun baseLayoutId(): Int = R.layout.activity_capture_picture_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 截图按钮
        val view = QuickHelper.get(BaseTextView(this))
            .setText("截图")
            .setBold()
            .setTextColor(ResourceUtils.getColor(R.color.white))
            .setTextSizeBySp(15.0f)
            .setPaddingLeft(30)
            .setPaddingRight(30)
            .setOnClicks {
                val filePath = PathConfig.AEP_DOWN_IMAGE_PATH
                val fileName = "list.jpg"
                val bitmap = CapturePictureUtils.snapshotByListView(binding.vidAcpList)
                val result = ImageUtils.saveBitmapToSDCardJPEG(bitmap, filePath + fileName)
                showToast(result, "保存成功\n" + (filePath + fileName), "保存失败")
            }.getView<View>()
        toolbar?.addView(view)
    }

    override fun initValue() {
        super.initValue()

        val lists = newAdapterBeanList(15)
        // 设置适配器
        binding.vidAcpList.adapter = object : BaseAdapter() {
            override fun getCount(): Int {
                return lists.size
            }

            override fun getItem(position: Int): AdapterBean {
                return lists[position]
            }

            override fun getItemId(position: Int): Long {
                return position.toLong()
            }

            override fun getView(
                position: Int,
                convertView: View,
                parent: ViewGroup
            ): View {
                val adapterBean = getItem(position)
                // 初始化 View 设置 TextView
                var _binding = AdapterCapturePictureBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ViewHelper.get()
                    .setText(_binding.vidAcpTitleTv, adapterBean.title)
                    .setText(_binding.vidAcpContentTv, adapterBean.title)
                return _binding.root
            }
        }
    }
}