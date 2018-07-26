package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import EntityFactory
import RoomEntityFactory
import io.reactivex.functions.Function
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

open class RepositoryDataEmbeddedFromRoomMapperTest {
    companion object {
        private const val OWNER_ID: Int = 1
        private const val LICENSE_KEY: String = "key"
        private const val REPO_ID: Int = 1
    }

    private lateinit var repositoryDataFromRoomMapper: Function<RoomRepositoryData, RepositoryData>
    private lateinit var licenseFromRoomMapper: Function<RoomLicense, License>
    private lateinit var ownerFromRoomMapper: Function<RoomOwner, Owner>
    private lateinit var repositoryDataEmbeddedFromRoomMapper: RepositoryDataEmbeddedFromRoomMapper
    @Before
    fun before() {
        repositoryDataFromRoomMapper = RepositoryDataFromRoomMapper()
        licenseFromRoomMapper = LicenseFromRoomMapper()
        ownerFromRoomMapper = OwnerFromRoomMapper()
        repositoryDataEmbeddedFromRoomMapper = RepositoryDataEmbeddedFromRoomMapper(repositoryDataFromRoomMapper,
                licenseFromRoomMapper,
                ownerFromRoomMapper)

    }

    @Test
    fun testMapper() {
        val roomRepositoryDataEmbedded: RoomRepositoryDataEmbedded = RoomEntityFactory.makeRoomRepositoryDataEmbeddeEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        val repositoryData: RepositoryData = EntityFactory.makeRepositoryDataEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        assertThat(repositoryDataEmbeddedFromRoomMapper.apply(roomRepositoryDataEmbedded), equalTo(repositoryData))

    }
}