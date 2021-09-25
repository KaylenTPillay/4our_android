package co.za.kaylen.pillay.four.app.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import co.za.kaylen.pillay.four.app.onboarding.listener.OnBoardingListener
import co.za.kaylen.pillay.four.databinding.ViewOnboardingLayoutBinding
import co.za.kaylen.pillay.shared_ui.fragment.addBackPressCallback

internal class ViewOnBoardingFragment : Fragment() {

    private var binding: ViewOnboardingLayoutBinding? = null
    private var listener: OnBoardingListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val parent = parentFragment ?: context
        listener = parent as? OnBoardingListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ViewOnboardingLayoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addBackPressCallback { listener?.onBoardingFinished() }

    }

    companion object {
        val TAG: String = ViewOnBoardingFragment::class.java.simpleName
        val MODEL: String = "Model_$TAG"
    }
}