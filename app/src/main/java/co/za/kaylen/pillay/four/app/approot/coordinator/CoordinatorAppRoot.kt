package co.za.kaylen.pillay.four.app.approot.coordinator

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

internal interface CoordinatorAppRoot {

    fun attach(
        containerId: Int,
        context: Context,
        manager: FragmentManager,
        lifecycleOwner: LifecycleOwner
    )

    fun navigate(model: CoordinatorAppRootModel)

}
