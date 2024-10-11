package Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime

@Entity(
    tableName = "Sales",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["idproduct"],
            childColumns = ["product_Id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["product_Id"]) ]
)
data class Sales(

    @PrimaryKey(autoGenerate = true)
    val idVenta: Int = 0,

    @ColumnInfo(name = "date_sale")
    val dateSale: LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "amount_sale")
    val amountSale: Int = 0,

    @ColumnInfo(name = "product_Id")
    val productoId: Int = 0,

)
