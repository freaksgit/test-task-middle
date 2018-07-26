package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import EntityFactory
import RoomEntityFactory
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License

open class LicenseToRoomMapperTest {
    companion object {
        private const val LICENSE_KEY: String = "key"
    }

    lateinit var licenseToRoomMapper: LicenseToRoomMapper

    @Before
    fun before() {
        licenseToRoomMapper = LicenseToRoomMapper()
    }

    @Test
    fun testMapper() {
        val roomLicense: RoomLicense = RoomEntityFactory.makeRoomLicenseEntity(LICENSE_KEY)
        val license: License? = EntityFactory.makeLicenseEntity(LICENSE_KEY)
        MatcherAssert.assertThat(licenseToRoomMapper.apply(license!!), CoreMatchers.equalTo(roomLicense))
    }
}