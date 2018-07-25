package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.base.BaseDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded

@Dao
abstract class RepositoryDataDao : BaseDao<RoomRepositoryData> {

    @Transaction
    @Query("SELECT * FROM " + RoomRepositoryData.TABLE_NAME /*+ " R INNER JOIN " + RoomLicense.TABLE_NAME + " L ON R."
            + RoomRepositoryData.COLUMN_LICENSE_KEY + " = L." + RoomLicense.COLUMN_KEY
            + " INNER JOIN " + RoomOwner.TABLE_NAME + " O ON R." + RoomRepositoryData.COLUMN_OWNER_ID + " = O." + RoomOwner.COLUMN_ID*/)
    abstract fun getEmbeddedRepositories(): Maybe<List<RoomRepositoryDataEmbedded>>
}