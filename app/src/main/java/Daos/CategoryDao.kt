package Daos

import Entitys.Category
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM category")
    suspend fun getAllCategorys(): List<Category>

}