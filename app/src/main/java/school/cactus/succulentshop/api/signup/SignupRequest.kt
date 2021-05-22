package school.cactus.succulentshop.api.signup

data class SignupRequest(
    val email: String,
    val password: String,
    val username: String
)
