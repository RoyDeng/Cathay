package tw.roy.deng.cathay.ui.page1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tw.roy.deng.cathay.data.model.Item
import tw.roy.deng.cathay.utils.asLiveData
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class Page1FragmentViewModel @Inject constructor(
) : ViewModel() {
    private val _items = MutableLiveData<List<Item>?>()
    val items = _items.asLiveData()

    fun getItems() {
        viewModelScope.launch {
            val items : MutableList<Item> = mutableListOf()

            for (i in 0..19 step 1) {
                val calendar = Calendar.getInstance()
                calendar.time = Date()

                calendar.add(Calendar.DATE, -19)
                calendar.add(Calendar.DATE, i)

                val sdf = SimpleDateFormat("MM-dd")
                val date = sdf.format(calendar.time)
                var week = ""

                when (calendar.get(Calendar.DAY_OF_WEEK)) {
                    1 -> week = "Sunday"
                    2 -> week = "Monday"
                    3 -> week = "Tuesday"
                    4 -> week = "Wednesday"
                    5 -> week = "Thursday"
                    6 -> week = "Friday"
                    7 -> week = "Saturday"
                }

                val item = Item("項目${i + 1}", date, week)

                items.add(item)
            }

            _items.postValue(items)
        }
    }
}
