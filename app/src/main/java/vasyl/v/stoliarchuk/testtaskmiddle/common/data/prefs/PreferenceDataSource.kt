package vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs

interface PreferenceDataSource {

    fun putString(key: String, value: String?)

    fun getString(key: String, defaultValue: String): String

    fun putInteger(key: String, value: Int)

    fun getInteger(key: String, defaultValue: Int): Int

    fun putLong(key: String, value: Long)

    fun getLong(key: String, defaultValue: Long): Long

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean
}
