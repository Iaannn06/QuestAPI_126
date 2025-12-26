package com.example.localrestapi.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.localrestapi.uicontroller.route.DestinasiDetail
import com.example.localrestapi.uicontroller.route.DestinasiEdit
import com.example.localrestapi.uicontroller.route.DestinasiEntry
import com.example.localrestapi.uicontroller.route.DestinasiHome
import com.example.localrestapi.view.DetailSiswaScreen
import com.example.localrestapi.view.EntrySiswaScreen
import com.example.localrestapi.view.HalamanEdit
import com.example.localrestapi.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { idSiswa ->
                    navController.navigate("${DestinasiDetail.route}/$idSiswa")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) { type = NavType.IntType })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { idSiswa ->
                    navController.navigate("${DestinasiEdit.route}/$idSiswa")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) { type = NavType.IntType })
        ) {
            HalamanEdit(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(DestinasiHome.route) { inclusive = true }
                    }
                },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}