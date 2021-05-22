package school.cactus.succulentshop.validation

import school.cactus.succulentshop.R

class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.email_cannot_be_empty
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null

    }

    override fun signupValidate(field: String) = when {
        field.isEmpty() -> R.string.email_required
        field.length < 5 || field.length > 50 -> R.string.invalid_email
        (!field.contains("@") || !field.contains(".")) -> R.string.invalid_email
        else -> null
    }


}
