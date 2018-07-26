package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

open class RepositoryDataToRoomMapperTest {
    companion object {
        private const val OWNER_ID: Int = 1
        private const val LICENSE_KEY: String = "key"
        private const val REPO_ID: Int = 1
    }

    lateinit var repositoryDataToRoomMapper: RepositoryDataToRoomMapper

    @Before
    fun before() {
        repositoryDataToRoomMapper = RepositoryDataToRoomMapper()
    }

    @Test
    fun testMapper() {
        val roomRepositoryData: RoomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        val repositoryData: RepositoryData = EntityFactory.makeRepositoryDataEntity(REPO_ID, OWNER_ID, LICENSE_KEY)
        MatcherAssert.assertThat(repositoryDataToRoomMapper.apply(repositoryData), CoreMatchers.equalTo(roomRepositoryData))
    }
}