package tw.roy.deng.cathay.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerAppCompatActivity
import tw.roy.deng.cathay.R
import tw.roy.deng.cathay.databinding.ActivityMainBinding
import tw.roy.deng.cathay.ui.adapter.PageAdapter
import tw.roy.deng.cathay.ui.page1.Page1Fragment
import tw.roy.deng.cathay.ui.page2.Page2Fragment

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PageAdapter

    var touchableList: ArrayList<View>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = PageAdapter(this)

        adapter.addFragment(Page1Fragment())
        adapter.addFragment(Page2Fragment())

        binding.viewPager.adapter = adapter

        val titleTextArray = arrayOf("線上測驗A", "線上測驗B")

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.textViewTitle.text = titleTextArray[position]
            }
        })

        val tabTextArray = arrayOf("分頁1", "分頁2")

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTextArray[position]
        }.attach()

        touchableList = binding.tabLayout?.touchables
    }
}