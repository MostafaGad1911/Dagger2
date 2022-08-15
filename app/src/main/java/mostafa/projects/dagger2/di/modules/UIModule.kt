package mostafa.projects.dagger2.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apiTask.AppsSquare.Model.Product
import dagger.Module
import dagger.Provides
import mostafa.projects.dagger2.DaggerApp
import mostafa.projects.dagger2.helper.Constants.SHARED_NAME
import mostafa.projects.dagger2.ui.adapter.ProductsAdapter
import javax.inject.Named
import javax.inject.Singleton

@Module
class UIModule() {



    @Provides
    @Singleton
    fun provideProductsAdapter(products:ArrayList<Product>): ProductsAdapter =
        ProductsAdapter(products = products)

}