package tw.roy.deng.cathay.ui.page2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import dagger.android.support.DaggerFragment
import tw.roy.deng.cathay.R
import tw.roy.deng.cathay.databinding.ActivityMainBinding
import tw.roy.deng.cathay.databinding.FragmentPage2Binding

class Page2Fragment : DaggerFragment() {
    private lateinit var binding: FragmentPage2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage2Binding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSwitch.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.view_pager)?.setCurrentItem(0, true)
        }
    }
}