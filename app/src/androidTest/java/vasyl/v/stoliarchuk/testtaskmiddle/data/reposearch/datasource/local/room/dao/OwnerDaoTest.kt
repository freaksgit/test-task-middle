package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import RoomEntityFactory
import android.database.sqlite.SQLiteConstraintException
import org.junit.Test

open class OwnerDaoTest : BaseRoomTest() {

    @Test
    fun insertOwner() {
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
    }


    @Test(expected = SQLiteConstraintException::class)
    fun insertOwnerTwice() {
        val roomOwner = RoomEntityFactory.makeRoomOwnerEntity(1)
        githubDatabase.onwerDao().insert(roomOwner)
        githubDatabase.onwerDao().insert(roomOwner)
    }
}