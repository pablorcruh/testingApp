package ec.com.pablorcruh.testingapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ec.com.pablorcruh.testingapp.core.data.coroutines.DefaultDispatchersProvider
import ec.com.pablorcruh.testingapp.core.domain.coroutines.DispatchersProvider
import ec.com.pablorcruh.testingapp.productlist.data.repository.ProductRepositoryImpl
import ec.com.pablorcruh.testingapp.productlist.domain.repository.ProductRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDispatchersProvider(defaultDispatchersProvider: DefaultDispatchersProvider): DispatchersProvider{
        return defaultDispatchersProvider
    }

    @Provides
    @Singleton
    fun providesProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository{
        return productRepositoryImpl
    }

}