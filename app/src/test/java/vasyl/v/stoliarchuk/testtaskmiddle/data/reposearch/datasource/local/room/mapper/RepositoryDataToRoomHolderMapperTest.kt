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
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataHolder
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

open class RepositoryDataToRoomHolderMapperTest {
    companion object {
        private const val OWNER_ID: Int = 1
        private const val LICENSE_KEY: String = "key"
        private const val REPO_ID: Int = 1
    }

    private lateinit var repositoryDataToRoomMapper: Function<RepositoryData, RoomRepositoryData>
    private lateinit var ownerToRoomMapper: Function<Owner, RoomOwner>
    private lateinit var licenseToRoomMapper: Function<License, RoomLicense>
    private lateinit var repositoryDataToRoomHolderMapper: RepositoryDataToRoomHolderMapper

    @Before
    fun before() {
        repositoryDataToRoomMapper = RepositoryDataToRoomMapper()
        ownerToRoomMapper = OwnerToRoomMapper()
        licenseToRoomMapper = LicenseToRoomMapper()
        repositoryDataToRoomHolderMapper = RepositoryDataToRoomHolderMapper(repositoryDataToRoomMapper, ownerToRoomMapper, licenseToRoomMapper)
    }

    @Test
    fun testMapper() {
        val roomRepositoryDataHolder: RoomRepositoryDataHolder = RoomEntityFactory.makeRoomRepositoryHolderEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        val repositoryData: RepositoryData = EntityFactory.makeRepositoryDataEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        assertThat(repositoryDataToRoomHolderMapper.apply(repositoryData), equalTo(roomRepositoryDataHolder))
    }
}