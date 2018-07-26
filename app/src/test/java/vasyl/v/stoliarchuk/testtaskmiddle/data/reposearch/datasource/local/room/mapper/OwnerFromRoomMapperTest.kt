package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import EntityFactory
import RoomEntityFactory
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner

open class OwnerFromRoomMapperTest {
    companion object {
        private const val OWNER_ID: Int = 1
    }

    lateinit var ownerFromRoomMapper: OwnerFromRoomMapper

    @Before
    fun before() {
        ownerFromRoomMapper = OwnerFromRoomMapper()
    }

    @Test
    fun testMapper() {
        val roomOwner: RoomOwner = RoomEntityFactory.makeRoomOwnerEntity(OWNER_ID)
        val owner: Owner? = EntityFactory.makeOwnerEntity(OWNER_ID)
        MatcherAssert.assertThat(ownerFromRoomMapper.apply(roomOwner), CoreMatchers.equalTo(owner))
    }
}