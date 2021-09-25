package co.za.kaylen.pillay.four.app.approot.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylen.pillay.four.app.approot.coordinator.factory.CoordinatorFactoryAppRoot
import co.za.kaylen.pillay.four.app.approot.viewmodel.ViewModelAppRoot
import co.za.kaylen.pillay.four.app.approot.viewmodel.impl.ViewModelAppRootImpl

@Suppress("unchecked_cast")
class ViewModelFactoryAppRoot : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAppRoot::class.java)) {
            return ViewModelAppRootImpl(
                coordinator = CoordinatorFactoryAppRoot.create()
            ) as T
        }

        throw IllegalStateException("Unable to create ViewModelAppRoot")
    }
}