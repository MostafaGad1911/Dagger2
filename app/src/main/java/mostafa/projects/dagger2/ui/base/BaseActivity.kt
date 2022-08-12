package mostafa.projects.dagger2.ui.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import mostafa.projects.dagger2.DaggerApp
import mostafa.projects.dagger2.R
import mostafa.projects.dagger2.network.vm.ProductsViewModel

abstract class BaseActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getRes())
        init()
        initViews()
    }


    abstract fun init()
    abstract fun initViews()
    abstract fun getRes():Int

    fun Activity.dagComponent() = (this.application as DaggerApp).appComponent()
    fun String.showToast() = Toast.makeText(this@BaseActivity , this , Toast.LENGTH_LONG).show()

}