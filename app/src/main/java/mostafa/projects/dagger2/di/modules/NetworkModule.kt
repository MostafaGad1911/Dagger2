package mostafa.projects.dagger2.di.modules

import dagger.Module
import dagger.Provides
import mostafa.projects.dagger2.network.Apis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl("https://android-training.appssquare.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @Provides
    fun provideApis(retrofit: Retrofit):Apis = retrofit.create(Apis::class.java)


}