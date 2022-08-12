package mostafa.projects.dagger2.network.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apiTask.AppsSquare.Model.DataModel
import kotlinx.coroutines.launch
import mostafa.projects.dagger2.DaggerApp
import mostafa.projects.dagger2.network.repository.DagRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ProductsViewModel() : ViewModel() {


    init {
        DaggerApp().appComponent().inject(this)
    }

    @Inject
    lateinit var repo: DagRepo

    var productsData: MutableLiveData<DataModel> = MutableLiveData()
    val productsLiveData: LiveData<DataModel> get() = productsData

    var errorData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String> get() = errorData

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            repo.getProducts().enqueue(object : Callback<DataModel> {
                override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                    when(response.code()){
                        200 -> {
                            productsData.postValue(response.body())
                        }
                        else -> {
                            errorData.postValue(response.errorBody()?.string())
                        }
                    }
                }

                override fun onFailure(call: Call<DataModel>, t: Throwable) {
                     errorData.postValue(t.message)
                }
            })
        }
    }
}