package ec.com.pablorcruh.testingapp.productlist.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PromotionsResponse(
    @SerialName("promotions")
    val promotions: List<PromotionResponse>
)
