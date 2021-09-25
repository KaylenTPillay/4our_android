package co.za.kaylen.pillay.shared_ui.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.io.Serializable
import kotlin.reflect.KClass

interface Navigator {

    fun navigate(
        containerId: Int,
        manager: FragmentManager,
        fragment: KClass<Fragment>,
        tag: String,
        modelKey: String,
        model: Serializable
    )

}