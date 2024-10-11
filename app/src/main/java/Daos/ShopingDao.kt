package Daos

import Entitys.Shoping
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import org.threeten.bp.LocalDateTime

@Dao
interface ShopingDao {

    @Insert
    suspend fun insertShoping(shoping: Shoping)

    @Update
    suspend fun updateShoping(shoping: Shoping)

    @Delete
    suspend fun deleteShoping(shoping: Shoping)

    @Query("DELETE FROM shopping WHERE idShoping = :id ")
    suspend fun deleteShopingById(id: Int)

    @Query("SELECT * FROM shopping")
    suspend fun getAllShoping(): List<Shoping>

    @Query("SELECT * FROM shopping WHERE idShoping = :id")
    suspend fun getShopingByProductId(id: Int): List<Shoping>

    @Query("SELECT * FROM shopping WHERE date_shop = :date")
    suspend fun getShipingByDate(date: LocalDateTime): List<Shoping>

}