package ec.com.pablorcruh.testingapp.productlist.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("description`")
    val description: String? = null,

    @SerialName("priceCents")
    val priceCents: Int? = null,

    @SerialName("category")
    val category: String? = null,

    @SerialName("stock")
    val stock: Int? = null,

    @SerialName("imageUrl")
    val imageUrl: String? = null
)
