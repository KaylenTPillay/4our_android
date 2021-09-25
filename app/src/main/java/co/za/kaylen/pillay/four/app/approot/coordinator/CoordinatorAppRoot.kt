package co.za.kaylen.pillay.four.app.approot.coordinator

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

internal interface CoordinatorAppRoot {

    fun attach(
        containerId: Int,
        manager: FragmentManager,
        lifecycleOwner: LifecycleOwner
    )

    fun navigate(model: CoordinatorAppRootModel)

}
