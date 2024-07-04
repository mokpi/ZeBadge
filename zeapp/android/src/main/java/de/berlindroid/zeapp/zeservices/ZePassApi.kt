package de.berlindroid.zeapp.zeservices

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class Message(
    val message: String,
    @SerializedName("posterUUID")
    val poster: String,
    @SerializedName("id")
    val id: String,
)

data class User(
    val name: String,
    val uuid: String,
    val profileB64: String,
)

interface ZePassService {
    @GET("/zepass")
    suspend fun getAllMessages(): List<Message>

    @GET("/zepass/{uuid}")
    suspend fun getOneMessage(
        @Path("uuid") uuid: String,
    ): Message

    @POST("/zepass")
    suspend fun postMessage(
        @Body uuid: String,
    )
}

private const val BASE_URL = "https://zebadge.app/api"

class ZePassAPI(
    private val service: ZePassService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ZePassService::class.java),
) {
    fun getUserProfilePng(user: User): String = "$BASE_URL/user/${user.uuid}/png"

    suspend fun getAllMessages(): List<Message> = service.getAllMessages()

    suspend fun postNewMessage(user: User) = service.postMessage(user.uuid)
}
