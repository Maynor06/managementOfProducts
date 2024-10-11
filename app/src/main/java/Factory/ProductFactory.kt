package Factory

import Daos.ProductDao
import ViewModals.CategoryViewModel
import ViewModals.ProductViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductFactory(private val productDao: ProductDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(productDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}