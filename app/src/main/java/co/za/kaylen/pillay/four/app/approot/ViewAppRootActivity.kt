package co.za.kaylen.pillay.four.app.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import co.za.kaylen.pillay.four.app.approot.viewmodel.ViewModelAppRoot
import co.za.kaylen.pillay.four.app.approot.viewmodel.factory.ViewModelFactoryAppRoot
import co.za.kaylen.pillay.four.app.onboarding.listener.OnBoardingListener
import co.za.kaylen.pillay.four.databinding.ViewAppRootLayoutBinding

internal class ViewAppRootActivity : AppCompatActivity(),
    OnBoardingListener {

    private val viewModel: ViewModelAppRoot by viewModels { ViewModelFactoryAppRoot() }
    private lateinit var binding: ViewAppRootLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initialiseBinding()
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onAttachCoordinator(
            containerId = binding.appRootContainerId.id,
            context = this,
            manager = supportFragmentManager,
            lifecycleOwner = this
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.init()
    }

    override fun onBoardingFinished() {
        viewModel.onBoardingComplete()
    }

    private fun initialiseBinding() {
        binding = ViewAppRootLayoutBinding.inflate(layoutInflater)
    }

}