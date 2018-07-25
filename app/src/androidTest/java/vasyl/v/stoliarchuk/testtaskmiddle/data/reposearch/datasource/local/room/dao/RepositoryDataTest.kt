package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import RoomEntityFactory
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteException
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class RepositoryDataTest : BaseRoomTest() {

    @Test(expected = SQLiteException::class)
    fun insertRepositoryDataWithoutOwner() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
    }

    @Test
    fun insertRepositoryDataWithOwner() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insertRepositoryDataTwiceWithOwner() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
    }

    @Test
    fun insertRepositoryDataAndGet() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({ assertThat(it[0].roomRepositoryData, equalTo(roomRepositoryData)) })
    }

    @Test
    fun insertRepositoryDataVarargAndGet() {
        val roomRepositoryData1 = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomRepositoryData2 = RoomEntityFactory.makeRoomRepositoryDataEntity(2)
        val roomOwner1 = RoomEntityFactory.makeRoomOwnerEntity(1)
        val roomOwner2 = RoomEntityFactory.makeRoomOwnerEntity(2)
        githubDatabase.onwerDao().insert(roomOwner1)
        githubDatabase.onwerDao().insert(roomOwner2)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData1, roomRepositoryData2)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({
                    assertThat(it[0].roomRepositoryData, equalTo(roomRepositoryData1))
                    assertThat(it[1].roomRepositoryData, equalTo(roomRepositoryData2))
                })
    }

    @Test
    fun insertAndDeleteRepositoryData() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({ assertThat(it[0].roomRepositoryData, equalTo(roomRepositoryData)) })
        githubDatabase.repositoryDataDao().delete(roomRepositoryData)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({
                    assertThat(it.isEmpty(), equalTo(true))
                })
    }

    @Test
    fun insertAndUpdateRepositoryData() {
        val roomRepositoryData = RoomEntityFactory.makeRoomRepositoryDataEntity(1)
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.repositoryDataDao().insert(roomRepositoryData)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({ assertThat(it[0].roomRepositoryData, equalTo(roomRepositoryData)) })

        roomRepositoryData.archiveUrl = "no url"
        githubDatabase.repositoryDataDao().update(roomRepositoryData)
        githubDatabase.repositoryDataDao().getEmbeddedRepositories()
                .subscribe({
                    assertThat(it[0].roomRepositoryData, equalTo(roomRepositoryData))
                })
    }


}