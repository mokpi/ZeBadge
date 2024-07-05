package de.berlindroid.zeapp.zeservices

import de.berlindroid.zeapp.zedi.ZeServerBaseUrl
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Inject

@Serializable
data class Message(
    val message: String,
    @SerialName("posterUUID")
    val poster: String,
    @SerialName("uuid")
    val id: String,
)

interface ZePassService {
    @GET("zepass")
    suspend fun getAllMessages(): List<Message>

    @GET("zepass/{uuid}")
    suspend fun getOneMessage(
        @Path("uuid") uuid: String,
    ): Message

    @POST("zepass")
    suspend fun postMessage(
        @Body uuid: String,
    )
}

class ZePassApi
@Inject constructor(
    private val service: ZePassService,
) {
    suspend fun getAllMessages(): List<Message> = service.getAllMessages()

    suspend fun postNewMessage(user: User) = service.postMessage(user.uuid)
}
