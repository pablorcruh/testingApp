package ec.com.pablorcruh.testingapp.productlist.data.mappers

import ec.com.pablorcruh.testingapp.productlist.data.local.database.entity.ProductEntity
import ec.com.pablorcruh.testingapp.productlist.data.remote.response.ProductResponse
import ec.com.pablorcruh.testingapp.productlist.domain.model.Product

fun ProductResponse.toEntity(): ProductEntity {
    val finalPrice = priceCents?.div(100.0)?: 0.0
    return ProductEntity(
        id = id,
        name= name,
        description = description,
        price = finalPrice,
        category = category,
        stock = stock,
        imageUrl = imageUrl
    )
}

fun ProductEntity.toDomain(): Product?{
    if(category.isNullOrEmpty()) return null
    return Product(
        id = id,
        name = name,
        description = description.orEmpty(),
        price = price,
        category = category,
        stock = stock ?: 0,
        imageUrl = imageUrl
    )
}