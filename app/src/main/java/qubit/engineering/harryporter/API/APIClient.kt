package qubit.engineering.harryporter.API

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


const val API_KEY = "\$2a\$10\$1JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP/IUZWIVwfsaF7y" // this is our api key from omdbapi
const val BASE_URL = "https://www.potterapi.com/v1/"//this is the base url that stays constant //http://www.omdbapi.com/?t=glass&y=2019&apikey=bcb1c45

object APIClient {

    fun getClient(): HousesInterface{
        val requestInterceptor = Interceptor{
                chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()
            print(url)

            return@Interceptor chain.proceed(request)

        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HousesInterface::class.java)


    }



}