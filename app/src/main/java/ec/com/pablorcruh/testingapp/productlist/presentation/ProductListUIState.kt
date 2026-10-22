package ec.com.pablorcruh.testingapp.productlist.presentation

sealed class ProductListUIState {
    data object Loading: ProductListUIState()
    data class Error(val message: String): ProductListUIState()
    data class Success(
        val selectedCategory: String
    ): ProductListUIState()
}