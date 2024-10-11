package Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime

@Entity(
    tableName = "Shopping",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["idproduct"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["product_id"]) ]
)
data class Shoping(

    @PrimaryKey(autoGenerate = true)
    val idShoping: Int = 0,

    @ColumnInfo(name = "product_id")
    val productId: Int = 0,

    @ColumnInfo(name = "amount_shoping")
    val amountShoping: Int = 0,

    @ColumnInfo(name = "purchase_price")
    val purchaseprice: Double,

    @ColumnInfo(name = "date_shop")
    val dateShop: LocalDateTime = LocalDateTime.now(),

)
