package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vasyl.v.stoliarchuk.testtaskmiddle.BuildConfig
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.GithubApi
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope


@Module
class NetworkModule {

    @Provides
    @AppScope
    fun provideOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(interceptor)
        }
        return httpClientBuilder.build()
    }

    @Provides
    @AppScope
    fun provideGson(): Gson {
        return GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }

    @Provides
    @AppScope
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(GithubApi.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @AppScope
    fun provideGithubApi(retrofit: Retrofit):GithubApi{
        return retrofit.create(GithubApi::class.java)
    }
}