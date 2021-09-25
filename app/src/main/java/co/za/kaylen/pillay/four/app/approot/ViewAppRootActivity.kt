package co.za.kaylen.pillay.four.app.approot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylen.pillay.four.databinding.ViewAppRootLayoutBinding

class ViewAppRootActivity : AppCompatActivity() {

    private lateinit var binding: ViewAppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()
        setContentView(binding.root)
    }

    private fun initialiseBinding() {
        binding = ViewAppRootLayoutBinding.inflate(layoutInflater)
    }

}