package ec.com.pablorcruh.testingapp.core.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun NavGraph(){
    val backStack = rememberNavBackStack(Screen.ProductList)

    val entries = entryProvider<NavKey>{
        entry<Screen.ProductList>{
            Text("Product List", fontSize = 30.sp)
        }
        entry<Screen.Cart>{
            Text("Cart", fontSize = 30.sp)
        }

        entry<Screen.Settings>{
            Text("Settings", fontSize = 30.sp)
        }
        entry<Screen.ProductDetail>{
            Text("Product Detail", fontSize = 30.sp)
        }
    }

    NavDisplay(
        backStack = backStack,
        entryProvider = entries,
        onBack = {backStack.removeLastOrNull()}
    )

}