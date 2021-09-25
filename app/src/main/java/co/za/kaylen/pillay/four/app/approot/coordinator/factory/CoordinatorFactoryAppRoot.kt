package co.za.kaylen.pillay.four.app.approot.coordinator.factory

import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRoot
import co.za.kaylen.pillay.four.app.approot.coordinator.impl.CoordinatorAppRootImpl
import co.za.kaylen.pillay.shared_ui.navigator.factory.NavigatorFactory

internal object CoordinatorFactoryAppRoot {

    fun create() : CoordinatorAppRoot {
        return CoordinatorAppRootImpl(
            navigator = NavigatorFactory.create()
        )
    }

}
