package ec.com.pablorcruh.testingapp.productlist.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import ec.com.pablorcruh.testingapp.productlist.data.local.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id = :id ")
    fun getProductById(id: String): Flow<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProduct(products: List<ProductEntity>)

    @Query("DELETE FROM products")
    suspend fun clearAllProducts()


    @Transaction
    suspend fun replaceAll(products: List<ProductEntity>){
        clearAllProducts()
        insertAllProduct(products)
    }
}