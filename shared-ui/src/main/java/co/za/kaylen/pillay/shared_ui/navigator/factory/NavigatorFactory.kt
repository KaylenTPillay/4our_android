package co.za.kaylen.pillay.shared_ui.navigator.factory

import co.za.kaylen.pillay.shared_ui.navigator.Navigator
import co.za.kaylen.pillay.shared_ui.navigator.impl.NavigatorImpl

object NavigatorFactory {

    fun create(): Navigator {
        return NavigatorImpl()
    }

}
