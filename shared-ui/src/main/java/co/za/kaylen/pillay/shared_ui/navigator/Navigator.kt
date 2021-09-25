package co.za.kaylen.pillay.shared_ui.navigator

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.io.Serializable
import kotlin.reflect.KClass

interface Navigator {

    fun <E: Fragment> navigate(
        containerId: Int,
        manager: FragmentManager,
        fragment: KClass<E>,
        tag: String,
        modelKey: String,
        model: Serializable
    )

    fun finish(context: Context?)

}