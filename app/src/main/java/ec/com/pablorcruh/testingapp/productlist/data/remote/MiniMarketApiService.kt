package ec.com.pablorcruh.testingapp.productlist.data.remote

import ec.com.pablorcruh.testingapp.productlist.data.remote.response.ProductsResponse
import ec.com.pablorcruh.testingapp.productlist.data.remote.response.PromotionsResponse
import retrofit2.http.GET

interface MiniMarketApiService {

    @GET("data/products.json")
    suspend fun getProducts(): ProductsResponse

    @GET("data/promotion.json")
    suspend fun getPromotions(): PromotionsResponse
}