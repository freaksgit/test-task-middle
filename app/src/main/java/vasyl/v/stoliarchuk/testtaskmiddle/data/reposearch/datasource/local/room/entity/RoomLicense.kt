package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomLicense.TABLE_NAME)
data class RoomLicense(@PrimaryKey @ColumnInfo(name = COLUMN_KEY) var key: String,
                       @ColumnInfo(name = "name") var name: String? = null,
                       @ColumnInfo(name = "spdxId") var spdxId: String? = null,
                       @ColumnInfo(name = "url") var url: String? = null,
                       @ColumnInfo(name = "nodeId") var nodeId: String? = null) {
    companion object {
        const val TABLE_NAME = "licenses_table"
        const val COLUMN_KEY = "key"
    }
}