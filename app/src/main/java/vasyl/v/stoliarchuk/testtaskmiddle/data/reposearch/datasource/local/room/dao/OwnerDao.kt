package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import android.arch.persistence.room.Dao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.base.BaseDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner

@Dao
abstract class OwnerDao: BaseDao<RoomOwner>{
}