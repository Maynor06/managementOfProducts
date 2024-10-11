package ViewModals

import Daos.CategoryDao
import Entitys.Category
import Entitys.Shoping
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryDao: CategoryDao): ViewModel() {

    private val _allCategory = MutableLiveData<List<Category>>()
    val allCategory: LiveData<List<Category>> get() = _allCategory;

    fun loadAllCategorys(){
        viewModelScope.launch {
            _allCategory.value = categoryDao.getAllCategorys()
        }
    }

    fun insetCategory(category: Category){
        viewModelScope.launch {
            categoryDao.insertCategory(category)
        }
    }


}