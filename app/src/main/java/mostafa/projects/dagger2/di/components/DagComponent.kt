package mostafa.projects.dagger2.di.components

import android.content.Context
import dagger.Component
import mostafa.projects.dagger2.DaggerApp
import mostafa.projects.dagger2.ui.activities.MainActivity
import mostafa.projects.dagger2.di.modules.DagModule
import mostafa.projects.dagger2.di.modules.NetworkModule
import mostafa.projects.dagger2.network.vm.ProductsViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [DagModule::class , NetworkModule::class])
interface DagComponent {
    fun inject(productsViewModel: ProductsViewModel)
    fun inject(mainActivity: MainActivity)
    fun app(): DaggerApp
    fun context(): Context
}