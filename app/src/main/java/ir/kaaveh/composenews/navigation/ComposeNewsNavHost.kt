package ir.kaaveh.composenews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ir.kaaveh.navigation.graph.favoriteMarketList
import ir.kaaveh.navigation.graph.marketDetail
import ir.kaaveh.navigation.graph.marketList
import ir.kaaveh.base.BaseViewModel
import ir.kaaveh.navigation.Destinations

@Composable
fun ComposeNewsNavHost(
    navController: NavHostController,
    modifier: Modifier,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.MarketListScreen.route,
        modifier = modifier,
    ) {
        marketList(navController, onProvideBaseViewModel)
        favoriteMarketList(navController, onProvideBaseViewModel)
        marketDetail(onProvideBaseViewModel)
    }
}