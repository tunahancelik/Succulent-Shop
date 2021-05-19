package school.cactus.succulentshop.signup.validation

import school.cactus.succulentshop.R
import school.cactus.succulentshop.validation.Validator

class UserNameValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.username_required
        field.length < 2 -> R.string.username_short
        field.length > 20 -> R.string.username_long
        !field.matches("^[a-z0-9_]+\$".toRegex()) -> R.string.username_regex
        else -> null
    }
}