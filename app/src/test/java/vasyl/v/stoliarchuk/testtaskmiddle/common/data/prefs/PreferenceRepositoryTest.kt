package vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs

import android.content.SharedPreferences
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit

class PreferenceRepositoryTest {
    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    companion object {
        private const val KEY_TEST: String = "test_key"
        private const val VALUE_STRING: String = "string"
        private const val VALUE_INTEGER: Int = 10
        private const val VALUE_LONG: Long = 10L
        private const val VALUE_BOOLEAN: Boolean = true
    }

    lateinit var preferenceRepository: PreferenceRepository

    @Mock
    lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var editor: SharedPreferences.Editor

    @Before
    fun before() {
        preferenceRepository = PreferenceRepository(sharedPreferences)
        `when`(sharedPreferences.edit()).thenReturn(editor)
    }

    @Test
    fun putString() {
        `when`(editor.putString(KEY_TEST, VALUE_STRING)).thenReturn(editor)

        preferenceRepository.putString(KEY_TEST, VALUE_STRING)

        verify(sharedPreferences).edit()
        verify(editor).putString(KEY_TEST, VALUE_STRING)
        verify(editor).apply()
    }

    @Test
    fun getString() {
        val defaultValue = ""
        `when`(sharedPreferences.getString(KEY_TEST, defaultValue)).thenReturn(VALUE_STRING)
        val returnedString = preferenceRepository.getString(KEY_TEST, defaultValue)

        assertThat(returnedString, equalTo(VALUE_STRING))
        verify(sharedPreferences).getString(KEY_TEST, defaultValue)
    }

    @Test
    fun putInteger() {
        `when`(editor.putInt(KEY_TEST, VALUE_INTEGER)).thenReturn(editor)

        preferenceRepository.putInteger(KEY_TEST, VALUE_INTEGER)
        verify(sharedPreferences).edit()
        verify(editor).putInt(KEY_TEST, VALUE_INTEGER)
        verify(editor).apply()
    }

    @Test
    fun getInteger() {
        val defaultValue = 0
        `when`(sharedPreferences.getInt(KEY_TEST, defaultValue)).thenReturn(VALUE_INTEGER)
        val returnedInt: Int = preferenceRepository.getInteger(KEY_TEST, defaultValue)

        assertThat(returnedInt, equalTo(VALUE_INTEGER))
        verify(sharedPreferences).getInt(KEY_TEST, defaultValue)
    }

    @Test
    fun putLong() {
        `when`(editor.putLong(KEY_TEST, VALUE_LONG)).thenReturn(editor)

        preferenceRepository.putLong(KEY_TEST, VALUE_LONG)
        verify(sharedPreferences).edit()
        verify(editor).putLong(KEY_TEST, VALUE_LONG)
        verify(editor).apply()
    }

    @Test
    fun getLong() {
        val defaultValue = 0L
        `when`(sharedPreferences.getLong(KEY_TEST, defaultValue)).thenReturn(VALUE_LONG)
        val returnedLong: Long = preferenceRepository.getLong(KEY_TEST, defaultValue)

        assertThat(returnedLong, equalTo(VALUE_LONG))
        verify(sharedPreferences).getLong(KEY_TEST, defaultValue)
    }

    @Test
    fun putBoolean() {
        `when`(editor.putBoolean(KEY_TEST, VALUE_BOOLEAN)).thenReturn(editor)

        preferenceRepository.putBoolean(KEY_TEST, VALUE_BOOLEAN)
        verify(sharedPreferences).edit()
        verify(editor).putBoolean(KEY_TEST, VALUE_BOOLEAN)
        verify(editor).apply()
    }

    @Test
    fun getBoolean() {
        val defaultValue = false
        `when`(sharedPreferences.getBoolean(KEY_TEST, defaultValue)).thenReturn(VALUE_BOOLEAN)
        val returnedBoolean: Boolean = preferenceRepository.getBoolean(KEY_TEST, defaultValue)

        assertThat(returnedBoolean, equalTo(VALUE_BOOLEAN))
        verify(sharedPreferences).getBoolean(KEY_TEST, defaultValue)
    }
}