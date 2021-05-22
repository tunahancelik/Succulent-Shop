package school.cactus.succulentshop.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import school.cactus.succulentshop.api.login.LoginRequest
import school.cactus.succulentshop.api.login.LoginResponse
import school.cactus.succulentshop.api.product.Product
import school.cactus.succulentshop.api.signup.SignupRequest
import school.cactus.succulentshop.api.signup.SignupResponse

interface SucculentShopApi {
    @POST("/auth/local")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/products")
    fun listAllProducts(): Call<List<Product>>

    @GET("/products/{id}")
    fun getProductById(@Path("id") id: Int): Call<Product>

    @POST("/auth/local/register")
    fun register(@Body signupRequest: SignupRequest): Call<SignupResponse>

    @GET("/related-products/{id}")
    fun relatedProducts(@Path("id") id: Int): Call<Product>


}