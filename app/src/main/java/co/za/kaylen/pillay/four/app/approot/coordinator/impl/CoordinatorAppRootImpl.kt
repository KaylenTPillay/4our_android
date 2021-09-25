package co.za.kaylen.pillay.four.app.approot.coordinator.impl

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRoot
import co.za.kaylen.pillay.four.app.approot.coordinator.CoordinatorAppRootModel
import co.za.kaylen.pillay.four.app.onboarding.ViewOnBoardingFragment
import co.za.kaylen.pillay.shared_ui.navigator.Navigator
import java.util.*

internal class CoordinatorAppRootImpl(
    private val navigator: Navigator
) : CoordinatorAppRoot, LifecycleObserver {

    private val navigationStack = Stack<CoordinatorAppRootModel>()

    private var containerId: Int = -1
    private var manager: FragmentManager? = null
    private var context: Context? = null

    override fun attach(containerId: Int, context: Context, manager: FragmentManager, lifecycleOwner: LifecycleOwner) {
        this.containerId = containerId
        this.manager = manager
        this.context = context

        lifecycleOwner.lifecycle.removeObserver(this)
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun navigate(model: CoordinatorAppRootModel) {
        when (model) {
            is CoordinatorAppRootModel.OnBoarding -> handleOnBoardingNavigation(model)
            is CoordinatorAppRootModel.OnBoardingComplete -> handleOnBoardingCompleteNavigation()
        }
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent() {
        containerId = -1
        manager = null
    }

    private fun handleOnBoardingNavigation(model: CoordinatorAppRootModel.OnBoarding) {
        performNavigationIfPossible(containerId, manager) { id, manager ->
            navigator.navigate(
                containerId = id,
                manager = manager,
                fragment = ViewOnBoardingFragment::class,
                tag = ViewOnBoardingFragment.TAG,
                modelKey = ViewOnBoardingFragment.MODEL,
                model = model.title
            )
            navigationStack.pushOrBringForward(model)
        }
    }

    private fun handleOnBoardingCompleteNavigation() {
        navigateBackOrFinish()
    }

    private fun navigateBackOrFinish() {
        navigationStack.pop()
        if (navigationStack.isNotEmpty()) {
            navigate(navigationStack.peek())
        } else {
            navigator.finish(context)
        }
    }

    private fun performNavigationIfPossible(
        containerId: Int,
        manager: FragmentManager?,
        onNavigate: (id: Int, manager: FragmentManager) -> Unit
    ) {
        if (containerId != -1 && manager != null) {
            onNavigate(containerId, manager)
        }
    }

}

private fun Stack<CoordinatorAppRootModel>.pushOrBringForward(model: CoordinatorAppRootModel) {
    indexOfFirst { it == model }.takeIf { index -> index != -1 }?.let { removeAt(it) }
    push(model)
}
