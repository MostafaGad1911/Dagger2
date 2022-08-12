package mostafa.projects.dagger2.network.repository

import com.apiTask.AppsSquare.Model.DataModel
import mostafa.projects.dagger2.network.Apis
import retrofit2.Call
import javax.inject.Inject

class DagRepo @Inject constructor(private val apis:Apis) {

    fun getProducts():Call<DataModel> = apis.getData()
}