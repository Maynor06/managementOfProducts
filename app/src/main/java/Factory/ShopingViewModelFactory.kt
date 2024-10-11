package Factory

import Daos.ShopingDao
import ShopingViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShopingViewModelFactory(private val shopingDao: ShopingDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShopingViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ShopingViewModel(shopingDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}