package co.za.kaylen.pillay.shared_ui.navigator.impl

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import co.za.kaylen.pillay.shared_ui.navigator.Navigator
import java.io.Serializable
import kotlin.reflect.KClass

internal class NavigatorImpl : Navigator {

    override fun <E: Fragment> navigate(
        containerId: Int,
        manager: FragmentManager,
        fragment: KClass<E>,
        tag: String,
        modelKey: String,
        model: Serializable
    ) {

        val bundle = Bundle().apply { putSerializable(modelKey, model) }

        val transaction = manager.beginTransaction()
        transaction.replace(containerId, fragment.java, bundle, tag)
        transaction.commit()

    }

    override fun finish(context: Context?) {
        (context as? Activity)?.finish()
    }
}