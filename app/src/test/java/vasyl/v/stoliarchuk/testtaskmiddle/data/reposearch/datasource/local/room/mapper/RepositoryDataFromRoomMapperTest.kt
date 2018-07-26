package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import EntityFactory
import RoomEntityFactory
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

open class RepositoryDataFromRoomMapperTest {
    companion object {
        private const val OWNER_ID: Int = 1
        private const val LICENSE_KEY: String = "key"
        private const val REPO_ID: Int = 1
    }

    lateinit var repositoryDataFromRoomMapper: RepositoryDataFromRoomMapper

    @Before
    fun before() {
        repositoryDataFromRoomMapper = RepositoryDataFromRoomMapper()
    }

    @Test
    fun testMapper() {
        val roomRepositoryData: RoomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(REPO_ID, null, null)
        val repositoryData: RepositoryData = EntityFactory.makeRepositoryDataEntity(REPO_ID, null, null)
        MatcherAssert.assertThat(repositoryDataFromRoomMapper.apply(roomRepositoryData), CoreMatchers.equalTo(repositoryData))
    }
}