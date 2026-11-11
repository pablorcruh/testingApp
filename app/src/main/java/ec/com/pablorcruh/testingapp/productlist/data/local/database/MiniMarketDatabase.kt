package ec.com.pablorcruh.testingapp.productlist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ec.com.pablorcruh.testingapp.productlist.data.local.database.dao.ProductDao
import ec.com.pablorcruh.testingapp.productlist.data.local.database.dao.PromotionDao
import ec.com.pablorcruh.testingapp.productlist.data.local.database.entity.ProductEntity
import ec.com.pablorcruh.testingapp.productlist.data.local.database.entity.PromotionEntity


@Database(
    entities = [ProductEntity::class, PromotionEntity::class],
    version = 1,
    exportSchema = true
)
abstract class MiniMarketDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    abstract fun promotionDao(): PromotionDao
}