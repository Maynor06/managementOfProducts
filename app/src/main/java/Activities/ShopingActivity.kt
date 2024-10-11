package Activities

import Factory.ShopingViewModelFactory
import ShopingViewModel
import Utils.AppDatabase
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.managerproducts.R

class ShopingActivity : AppCompatActivity() {

    private lateinit var shopingViewModel: ShopingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shoping)

        val shopingDao = AppDatabase.getDatabase(application).shopingDao()
        val viewModelFactory = ShopingViewModelFactory(shopingDao)
        shopingViewModel = ViewModelProvider(this, viewModelFactory).get(ShopingViewModel::class.java)

        shopingViewModel.allShoping.observe(this){
            shopingList ->
        }

        shopingViewModel.loadAllShoping()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}