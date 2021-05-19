package school.cactus.succulentshop.helpers

import school.cactus.succulentshop.R
import school.cactus.succulentshop.Validator

class PasswordValidator : Validator {

    val chareacterSet = "-@%\\[\\}+'!/#$^?:;,\\(\"\\)~`.*=&\\{>\\]<_"
    val PASSWORD_RULE = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[$chareacterSet])(?=\\S+$).{8,20}$"

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.password_required
        field.length < 7 -> R.string.password_short
        field.length > 40 -> R.string.password_long
        !field.matches(PASSWORD_RULE.toRegex()) -> R.string.password_contain
        else -> null
    }
}