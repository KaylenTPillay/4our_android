package co.za.kaylen.pillay.four.app.approot.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

internal interface ViewModelAppRoot {

    fun onAttachCoordinator(
        containerId: Int,
        manager: FragmentManager,
        lifecycleOwner: LifecycleOwner
    )

    fun init()

}