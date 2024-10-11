package Factory

import Daos.SalesDao
import ViewModals.CategoryViewModel
import ViewModals.SalesViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SalesFactory(private val salesDao: SalesDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SalesViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return SalesViewModel(salesDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}