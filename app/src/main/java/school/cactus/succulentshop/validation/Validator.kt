package school.cactus.succulentshop.validation

interface Validator {
    fun validate(field: String): Int?
    fun signupValidate(field: String): Int?
}