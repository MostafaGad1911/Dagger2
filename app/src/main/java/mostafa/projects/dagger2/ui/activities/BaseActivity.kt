package mostafa.projects.dagger2.ui.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mostafa.projects.dagger2.DaggerApp
import mostafa.projects.dagger2.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getRes())
        init()
        initViews()
    }

    abstract fun init()
    abstract fun initViews()
    abstract fun getRes():Int

    fun Activity.dagComponent() = (this.application as DaggerApp).component

}