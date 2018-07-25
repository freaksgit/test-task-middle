package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import android.database.sqlite.SQLiteConstraintException
import org.junit.Test

open class LicenseDaoTest : BaseRoomTest() {

    @Test
    fun insertLicense() {
        val roomLicense = RoomEntityFactory.makeRoomLicenseEntity("1")
        githubDatabase.licenseDao().insert(roomLicense)
    }


    @Test(expected = SQLiteConstraintException::class)
    fun insertLicenseTwice() {
        val roomLicense = RoomEntityFactory.makeRoomLicenseEntity("1")
        githubDatabase.licenseDao().insert(roomLicense)
        githubDatabase.licenseDao().insert(roomLicense)
    }
}