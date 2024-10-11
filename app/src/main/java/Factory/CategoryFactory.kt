package Factory

import Daos.CategoryDao
import ViewModals.CategoryViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CategoryFactory(private val categoryDao: CategoryDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CategoryViewModel(categoryDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}