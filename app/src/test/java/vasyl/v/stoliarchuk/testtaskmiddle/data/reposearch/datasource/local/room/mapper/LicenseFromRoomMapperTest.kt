package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import EntityFactory
import RoomEntityFactory
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License

open class LicenseFromRoomMapperTest {

    companion object {
        private const val LICENSE_KEY: String = "key"
    }

    lateinit var licenseFromRoomMapper: LicenseFromRoomMapper


    @Before
    fun before() {
        licenseFromRoomMapper = LicenseFromRoomMapper()
    }

    @Test
    fun testMapper() {
        val roomLicense: RoomLicense = RoomEntityFactory.makeRoomLicenseEntity(LICENSE_KEY)
        val license: License? = EntityFactory.makeLicenseEntity(LICENSE_KEY)
        assertThat(licenseFromRoomMapper.apply(roomLicense), equalTo(license))
    }
}