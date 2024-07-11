package net.ezra.navigation



//import net.ezra.ui.auth.SignupScreen
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.SplashScreen
import net.ezra.ui.about.AboutScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignUpScreen
import net.ezra.ui.products.ShoppingCartScreen
import net.ezra.ui.dashboard.DashboardScreen
import net.ezra.ui.dashboard.UserDashboardScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.products.AddProductScreen
import net.ezra.ui.products.AddspecialoffersScreen
import net.ezra.ui.products.OffersListScreen
import net.ezra.ui.products.ProductDetailScreen
import net.ezra.ui.products.ProductListScreen
import net.ezra.ui.products.UpdateProductScreen
import net.ezra.ui.products.UserProductsScreen
import net.ezra.ui.students.AddStudents
import net.ezra.ui.students.Search
import net.ezra.ui.students.Students


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {


    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }


        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }


        composable(ROUTE_ADD_STUDENTS) {
            AddStudents(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_VIEW_STUDENTS) {
           Students(navController = navController, viewModel = viewModel() )
        }

        composable(ROUTE_SEARCH) {
            Search(navController)
        }

        composable(ROUTE_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUTE_REGISTER) {
           SignUpScreen(navController = navController) {

           }
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController = navController){}
        }

        composable(ROUTE_ADD_PRODUCT) {
            AddProductScreen(navController = navController){}
        }
        composable(ROUTE_ADD_SPECIALOFFER) {
            AddspecialoffersScreen(navController = navController){}
        }
        composable(ROUTE_VIEW_SPECIALOFFER) {
            OffersListScreen(navController = navController)
        }

        composable(ROUTE_VIEW_PROD) {
            ProductListScreen(navController = navController, products = listOf() )
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(navController, productId)
        }
        composable(ROUTE_USER_DASHBOARD) {
            UserDashboardScreen(navController = navController)
            }
        composable(ROUTE_SHOPPING_CART) {
            ShoppingCartScreen(navController = navController)
        }
        composable(ROUTE_VIEW_USER_PRODUCTS) {
            UserProductsScreen(navController)
        }
        composable("editProduct/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            UpdateProductScreen(navController = navController, productId = productId)
        }





































    }
}


