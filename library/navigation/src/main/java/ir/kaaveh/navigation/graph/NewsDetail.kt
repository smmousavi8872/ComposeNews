package ir.kaaveh.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.kaaveh.base.BaseViewModel
import ir.kaaveh.domain.model.Market
import ir.kaaveh.marketdetail.MarketDetailRoute
import ir.kaaveh.navigation.Destinations
import ir.kaaveh.navigation.extension_function.parcelableData

fun NavGraphBuilder.marketDetail(
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    composable(
        route = Destinations.MarketDetailScreen().route,
    ) { entry ->
        val market = entry.parcelableData<Market>(Destinations.MarketDetailScreen().market)
        MarketDetailRoute(
            market = market,
            onProvideBaseViewModel = {
                onProvideBaseViewModel(it)
            },
        )
    }
}