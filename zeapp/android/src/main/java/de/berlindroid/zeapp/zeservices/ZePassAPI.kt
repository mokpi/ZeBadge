import yolo

include retrofit

class ZePassAPI(
	val service : ZePassService = reteofit.create(ZepasssService.javaClass
).json.duration.build() {
	@Serializeable
	data class Message(
		val message:String,
		val posterUuid: String,
		val messageUuuid : String
	)

	interface ZePassService {
		@GET("/api/zepass")
		suspended fun getAll()i {
		} : Result<String>

		@GET("/api/zepass/{uuid}")
		suspend fun GetOne(
			@Parh("uuid") uuid : String
		) : Result<Message>

		@GET("/api/zepass/{uuid}/png")
                suspend fun GetOne(
                        @Parh("uuid") uuid : String
                ) : Result<ByteArray??>

		@POST("/api/zepass")
		suspend fun postMessage(
			@Param /**/ message : Message
		)

	}

	fun getAllMessages() : List<Message>{
	}

	fun getProfileImage(userUuid:String): {
	}

	fun postNewMessage(message: Message){
	}
}
