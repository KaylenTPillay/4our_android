package co.za.kaylen.pillay.four.app.approot.coordinator

sealed class CoordinatorAppRootModel {

    data class OnBoarding(val title: String) : CoordinatorAppRootModel()

    object OnBoardingComplete : CoordinatorAppRootModel()

}