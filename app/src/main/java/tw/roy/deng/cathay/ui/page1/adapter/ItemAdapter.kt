package tw.roy.deng.cathay.ui.page1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tw.roy.deng.cathay.data.model.Item
import tw.roy.deng.cathay.databinding.ItemDateBinding

class ItemAdapter : ListAdapter<Item, RecyclerView.ViewHolder>(ItemComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        item?.let { item ->
            val viewHolder = holder as ItemViewHolder

            viewHolder.itemPostBinding.textViewTitle.text = item.title
            viewHolder.itemPostBinding.textViewDate.text = "${item.date}(${item.week})"
        }
    }

    class ItemViewHolder(val itemPostBinding: ItemDateBinding) : RecyclerView.ViewHolder(itemPostBinding.root)

    companion object {
        private val ItemComparator = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}