package Daos

import Entitys.Sales
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import org.threeten.bp.LocalDateTime

@Dao
interface SalesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSale(sale: Sales)

    @Update
    suspend fun updateSale(sale: Sales)

    @Delete
    suspend fun deleteSales(sale: Sales)

    @Query("SELECT * FROM Sales")
    suspend fun getAllSales(): List<Sales>

    @Query("SELECT * FROM Sales WHERE product_Id = :productId")
    suspend fun getSalesByProductId(productId: Int): List<Sales>

    @Query("SELECT * FROM Sales WHERE Sales.date_sale = :date")
    suspend fun getSalesByDate (date: LocalDateTime): List<Sales>

}