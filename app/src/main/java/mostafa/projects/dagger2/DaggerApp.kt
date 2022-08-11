package mostafa.projects.dagger2

import android.app.Application
import androidx.multidex.MultiDexApplication
import mostafa.projects.dagger2.di.components.DagComponent
import mostafa.projects.dagger2.di.components.DaggerDagComponent
import mostafa.projects.dagger2.di.modules.DagModule

class DaggerApp: MultiDexApplication() {

    val component: DagComponent by lazy {
        DaggerDagComponent.builder()
            .dagModule(DagModule(this))
            .build()
    }
    override fun onCreate() {
        super.onCreate()
    }
}