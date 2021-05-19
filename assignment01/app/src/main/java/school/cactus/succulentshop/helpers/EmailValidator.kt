package school.cactus.succulentshop.helpers

import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validator

class EmailValidator : Validator {

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_required
        !field.contains("@") -> R.string.email_invalid
        !field.contains(".") -> R.string.email_invalid
        field.length < 5 -> R.string.email_invalid
        field.length > 50 -> R.string.email_invalid
        else -> null
    }
}