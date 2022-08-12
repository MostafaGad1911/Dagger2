package mostafa.projects.dagger2.network

import com.apiTask.AppsSquare.Model.DataModel
import com.apiTask.AppsSquare.Model.LoginData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Apis {
    @GET("products")
    fun getData(
    ): Call<DataModel>

    @POST("login")
    fun login(
        @Body loginData: LoginData
    ): Call<ResponseBody>
}