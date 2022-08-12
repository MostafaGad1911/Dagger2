package mostafa.projects.dagger2.ui.activities

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.Model.Product
import mostafa.projects.dagger2.R
import mostafa.projects.dagger2.helper.Constants.TEST_VALUE_NAME
import mostafa.projects.dagger2.network.vm.ProductsViewModel
import mostafa.projects.dagger2.ui.adapter.ProductsAdapter
import mostafa.projects.dagger2.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private var productsList:ArrayList<Product> = ArrayList()

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var productsViewModel: ProductsViewModel
    override fun init() {
        productsAdapter = ProductsAdapter(productsList)
        productsViewModel = ViewModelProvider(this)[ProductsViewModel::class.java]
        dagComponent().inject(this)

        sharedPreferences.edit()?.putString(TEST_VALUE_NAME, "mostafa elsayed gad")?.apply()

        val name = sharedPreferences.getString(TEST_VALUE_NAME, "")
        Log.i(TEST_VALUE_NAME, "$name")

        productsViewModel.productsLiveData.observe(this) {
            productsList.addAll(it.data)
            productsAdapter.notifyItemRangeInserted(productsList.size.plus(1) , it.data.size)
            productsViewModel.productsLiveData.removeObservers(this)
        }
        productsViewModel.errorLiveData.observe(this) {
            it.showToast()
            productsViewModel.errorLiveData.removeObservers(this)
        }
    }

    override fun initViews() {
        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        productsRecyclerView.adapter = productsAdapter
    }

    override fun getRes(): Int = R.layout.activity_main


}