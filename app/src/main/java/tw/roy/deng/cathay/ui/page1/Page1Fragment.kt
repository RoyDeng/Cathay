package tw.roy.deng.cathay.ui.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import dagger.android.support.DaggerFragment
import tw.roy.deng.cathay.R
import tw.roy.deng.cathay.databinding.FragmentPage1Binding
import tw.roy.deng.cathay.factory.ViewModelProviderFactory
import tw.roy.deng.cathay.ui.page1.adapter.ItemAdapter
import javax.inject.Inject

class Page1Fragment : DaggerFragment() {
    private lateinit var binding: FragmentPage1Binding

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(Page1FragmentViewModel::class.java)
    }

    private lateinit var adapter: ItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage1Binding.inflate(inflater)

        adapter = ItemAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        binding.buttonSwitch.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.view_pager)?.setCurrentItem(1, true)
        }

        viewModel.getItems()

        viewModel.items.observe(viewLifecycleOwner, Observer { itmes ->
            itmes?.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        })
    }
}