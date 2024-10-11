package Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val idproduct: Int = 0,

    val category: String,

    @ColumnInfo(name = "name_Product")
    val nameProduct: String,

    @ColumnInfo(name = "cost_price")
    val costPrice: Double,

    @ColumnInfo(name = "sell_price")
    val sellPrice: Double,

    val stock: Int,

)
