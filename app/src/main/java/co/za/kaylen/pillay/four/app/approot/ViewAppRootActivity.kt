package co.za.kaylen.pillay.four.app.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRoot
import co.za.kaylen.pillay.four.app.approot.coordinator.factory.CoordinatorFactoryAppRoot
import co.za.kaylen.pillay.four.app.approot.viewmodel.ViewModelAppRoot
import co.za.kaylen.pillay.four.app.approot.viewmodel.factory.ViewModelFactoryAppRoot
import co.za.kaylen.pillay.four.databinding.ViewAppRootLayoutBinding

internal class ViewAppRootActivity : AppCompatActivity() {

    private val viewModel: ViewModelAppRoot by viewModels { ViewModelFactoryAppRoot() }
    private lateinit var binding: ViewAppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()
        setContentView(binding.root)

        viewModel.init()
    }

    override fun onStart() {
        super.onStart()
        viewModel.onAttachCoordinator(
            containerId = binding.appRootContainerId.id,
            manager = supportFragmentManager,
            lifecycleOwner = this
        )
    }

    private fun initialiseBinding() {
        binding = ViewAppRootLayoutBinding.inflate(layoutInflater)
    }

}