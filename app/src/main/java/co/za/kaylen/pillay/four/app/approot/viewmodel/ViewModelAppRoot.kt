package co.za.kaylen.pillay.four.app.approot.viewmodel

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

internal interface ViewModelAppRoot {

    fun onAttachCoordinator(
        containerId: Int,
        context: Context,
        manager: FragmentManager,
        lifecycleOwner: LifecycleOwner
    )

    fun init()

    fun onBoardingComplete()

}