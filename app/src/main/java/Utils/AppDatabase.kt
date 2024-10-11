package Utils

import Daos.CategoryDao
import Daos.ProductDao
import Daos.SalesDao
import Daos.ShopingDao
import Entitys.Category
import Entitys.Product
import Entitys.Sales
import Entitys.Shoping
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Product::class, Sales::class, Shoping::class, Category::class], version = 1)
@TypeConverters(DateConverters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productoDao(): ProductDao
    abstract fun salesDao(): SalesDao
    abstract fun shopingDao(): ShopingDao
    abstract fun categoryDao(): CategoryDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "data_Tienda"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }


    }


}