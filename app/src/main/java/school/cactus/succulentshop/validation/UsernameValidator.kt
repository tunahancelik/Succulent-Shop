package school.cactus.succulentshop.validation

import school.cactus.succulentshop.R

class UsernameValidator : Validator {

    override fun validate(field: String): Int? {
        return null
    }

    override fun signupValidate(field: String): Int? {
        val a = field.replace("_", "")
        var b: Int? = null
        when {
            !a.all { it.isLetterOrDigit() } -> b = R.string.username_rules
            field.isEmpty() -> b = R.string.required_username
            field.length < 3 -> b = R.string.username_short
            field.length > 20 -> b = R.string.username_long
            else -> null
        }
        return b
    }


}
