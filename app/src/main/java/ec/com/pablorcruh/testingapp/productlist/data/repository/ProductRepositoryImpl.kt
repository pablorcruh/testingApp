package ec.com.pablorcruh.testingapp.productlist.data.repository

import ec.com.pablorcruh.testingapp.core.domain.coroutines.DispatchersProvider
import ec.com.pablorcruh.testingapp.productlist.data.local.LocalDataSource
import ec.com.pablorcruh.testingapp.productlist.data.mappers.toDomain
import ec.com.pablorcruh.testingapp.productlist.data.mappers.toEntity
import ec.com.pablorcruh.testingapp.productlist.data.remote.RemoteDataSource
import ec.com.pablorcruh.testingapp.productlist.domain.model.Product
import ec.com.pablorcruh.testingapp.productlist.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    val localDataSource : LocalDataSource,
    val remoteDataSource: RemoteDataSource,
    val dispatchers: DispatchersProvider
): ProductRepository {

    private val refreshScope = CoroutineScope(SupervisorJob() + dispatchers.io)
    private val refreshMutex= Mutex()

    override fun getProducts(): Flow<List<Product>> {
        return localDataSource.getAllProducts().map{
                entities -> entities.mapNotNull{it.toDomain()}
            }
            .onStart {
                refreshScope.launch {
                    if(!refreshMutex.tryLock()) return@launch
                    try{
                        refreshProduct()
                    }catch(e: Exception){

                    }finally{
                        refreshMutex.unlock()
                    }
                }
            }
    }

    override fun getProductById(id: String): Flow<Product?> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProduct() {
        withContext(dispatchers.io){
            val products = remoteDataSource.getProducts().getOrThrow()
            val productsEntity = products.map{it.toEntity()}
            localDataSource.saveProducts(productsEntity)
        }
    }
}