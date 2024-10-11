package Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "category",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["idproduct"],
            childColumns = ["product_id"]
        )
    ],
    indices = [Index(value = ["product_id"])]

)
data class Category(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name_category")
    val nameCategory: String,

    @ColumnInfo(name = "product_id")
    val productId: Int,
)
