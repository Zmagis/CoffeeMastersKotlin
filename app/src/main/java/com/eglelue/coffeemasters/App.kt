package com.eglelue.coffeemasters

import android.annotation.SuppressLint
import android.media.tv.TvContract.Channels.Logo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.eglelue.coffeemasters.pages.InfoPage
import com.eglelue.coffeemasters.pages.MenuPage
import com.eglelue.coffeemasters.pages.OrderPage
import com.eglelue.coffeemasters.ui.theme.CoffeeMastersTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember {
        println("select")
        mutableStateOf((Routes.MenuPage.route))
    }

    Scaffold(
        topBar = { TopAppBar {
            Logo()
        }},
        bottomBar = {
            Navbar(
                selectedRoute = selectedRoute.value,
                onChange = {
                    selectedRoute.value = it
                }
            )
        }
    ) {
        when(selectedRoute.value) {
            Routes.MenuPage.route -> MenuPage(dataManager)
            Routes.OffersPage.route -> OffersPage()
            Routes.OrderPage.route -> OrderPage(dataManager)
            Routes.InfoPage.route -> InfoPage()
        }
    }
}

@Preview
@Composable
fun Logo() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")
    }
}