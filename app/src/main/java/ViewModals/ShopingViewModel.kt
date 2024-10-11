import androidx.lifecycle.*
import Entitys.Shoping
import Daos.ShopingDao
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDateTime

class ShopingViewModel(private val shopingDao: ShopingDao): ViewModel() {

    // LiveData para observar todos los registros de compras
    private val _allShoping = MutableLiveData<List<Shoping>>()
    val allShoping: LiveData<List<Shoping>> get() = _allShoping;

    fun loadAllShoping() {
        viewModelScope.launch{
            _allShoping.value = shopingDao.getAllShoping()
        }
    }

    // Método para insertar un nuevo registro
    fun insertShoping(shoping: Shoping) {
        viewModelScope.launch {
            shopingDao.insertShoping(shoping)
        }
    }

    // Método para actualizar un registro existente
    fun updateShoping(shoping: Shoping) {
        viewModelScope.launch {
            shopingDao.updateShoping(shoping)
        }
    }

    // Método para eliminar un registro
    fun deleteShoping(shoping: Shoping) {
        viewModelScope.launch {
            shopingDao.deleteShoping(shoping)
        }
    }

    fun deleteShopingById(id: Int){
        viewModelScope.launch {
            shopingDao.deleteShopingById(id)
        }
    }

    fun getShopingByProductId(id: Int){
        viewModelScope.launch {
            _allShoping.value = shopingDao.getShopingByProductId(id)
        }
    }

    fun getShopingByDate(date: LocalDateTime){
        viewModelScope.launch {
            _allShoping.value = shopingDao.getShipingByDate(date)
        }
    }

}
