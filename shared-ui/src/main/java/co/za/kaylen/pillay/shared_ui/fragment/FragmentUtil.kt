package co.za.kaylen.pillay.shared_ui.fragment

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.lang.Exception

fun Fragment.addBackPressCallback(callback: () -> Unit) {
    val activity: FragmentActivity? = try {
        requireActivity()
    } catch (exp: Exception) {
        null
    }

    activity?.onBackPressedDispatcher?.addCallback(this) {
        callback.invoke()
    }
}