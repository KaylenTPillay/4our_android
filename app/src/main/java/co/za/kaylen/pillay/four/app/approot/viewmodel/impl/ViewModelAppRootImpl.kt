package co.za.kaylen.pillay.four.app.approot.viewmodel.impl

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRoot
import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRootModel
import co.za.kaylen.pillay.four.app.approot.viewmodel.ViewModelAppRoot

internal class ViewModelAppRootImpl(
    private val coordinator: CoordinatorAppRoot
) : ViewModel(), ViewModelAppRoot {

    override fun onAttachCoordinator(
        containerId: Int,
        manager: FragmentManager,
        lifecycleOwner: LifecycleOwner
    ) {
        coordinator.attach(containerId, manager, lifecycleOwner)
    }

    override fun init() {
        coordinator.navigate(model = CoordinatorAppRootModel.OnBoarding("OnBoarding"))
    }
}