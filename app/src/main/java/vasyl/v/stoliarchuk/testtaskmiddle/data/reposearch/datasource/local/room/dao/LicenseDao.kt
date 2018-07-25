package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import android.arch.persistence.room.Dao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.base.BaseDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense

@Dao
abstract class LicenseDao : BaseDao<RoomLicense> {
}