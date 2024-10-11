package ViewModals

import Daos.SalesDao
import Entitys.Sales
import Entitys.Shoping
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime

class SalesViewModel(private val salesDao: SalesDao): ViewModel() {

    private val _allSales = MutableLiveData<List<Sales>>()
    val allSales: LiveData<List<Sales>> get() = _allSales;

    fun loadAllSales(){
        viewModelScope.launch {
            _allSales.value = salesDao.getAllSales();
        }
    }

    fun insertSale(sales: Sales){
        viewModelScope.launch {
            salesDao.insertSale(sales)
        }
    }

    fun updateSale(sales: Sales){
        viewModelScope.launch {
            salesDao.updateSale(sales)
        }
    }

    fun deleteSale(sales: Sales){
        viewModelScope.launch {
            salesDao.deleteSales(sales)
        }
    }

    fun getSaleByProductId(id: Int){
        viewModelScope.launch {
            _allSales.value = salesDao.getSalesByProductId(id)
        }
    }

    fun getSalesByDate(date: LocalDateTime){
        viewModelScope.launch {
            _allSales.value = salesDao.getSalesByDate(date)
        }
    }

}