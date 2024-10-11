package ViewModals

import Daos.ProductDao
import Entitys.Product
import Entitys.Shoping
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel(private val productDao: ProductDao): ViewModel() {

    private val _allProduct = MutableLiveData<List<Product>>()
    val allShoping: LiveData<List<Product>> get() = _allProduct;

    fun loadAllProduct(){
        viewModelScope.launch {
            _allProduct.value = productDao.getAllProducts()
        }
    }

    fun insertProduct(product: Product){
        viewModelScope.launch {
            productDao.insertProduct(product)
        }
    }

    fun updateProduct(product: Product){
        viewModelScope.launch {
            productDao.updateProduct(product)
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch {
            productDao.deleteProduct(product)
        }
    }

}