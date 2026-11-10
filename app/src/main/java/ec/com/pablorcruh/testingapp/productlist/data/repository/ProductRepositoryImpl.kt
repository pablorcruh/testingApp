package ec.com.pablorcruh.testingapp.productlist.data.repository

import ec.com.pablorcruh.testingapp.core.domain.coroutines.DispatchersProvider
import ec.com.pablorcruh.testingapp.productlist.data.remote.RemoteDataSource
import ec.com.pablorcruh.testingapp.productlist.domain.model.Product
import ec.com.pablorcruh.testingapp.productlist.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    val remoteDataSource: RemoteDataSource,
    val dispatchers: DispatchersProvider
): ProductRepository {
    override fun getProducts(): Flow<List<Product>> {
        TODO("Not yet implemented")
    }

    override fun getProductById(id: String): Flow<Product?> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProduct() {
        remoteDataSource.getProducts()
    }
}