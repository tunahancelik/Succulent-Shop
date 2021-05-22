package school.cactus.succulentshop.api.product

data class Image(
    val id: Long,
    val name: String,
    val width: Long,
    val height: Long,
    val formats: Formats,
)
