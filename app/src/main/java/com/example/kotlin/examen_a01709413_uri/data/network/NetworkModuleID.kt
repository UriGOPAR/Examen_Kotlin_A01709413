import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.kotlin.examen_a01709413_uri.data.network.ApiService
import com.example.kotlin.examen_a01709413_uri.utils.Constants

object NetworkModuleID {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    private val headerInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header("X-Api-Key", Constants.API) // Reemplaza "tu_api_key" con tu clave API real
            .build()
        chain.proceed(newRequest)
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .build()

    operator fun invoke(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(ApiService::class.java)
    }
}
