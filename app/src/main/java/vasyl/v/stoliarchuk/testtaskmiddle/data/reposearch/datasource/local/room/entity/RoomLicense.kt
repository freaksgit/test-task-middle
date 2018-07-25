package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomLicense.TABLE_NAME)
data class RoomLicense(@PrimaryKey @ColumnInfo(name = COLUMN_KEY) val key: String,
                       @ColumnInfo(name = "name") val name: String? = null,
                       @ColumnInfo(name = "spdxId") val spdxId: String? = null,
                       @ColumnInfo(name = "url") val url: String? = null,
                       @ColumnInfo(name = "nodeId") val nodeId: String? = null) {
    companion object {
        const val TABLE_NAME = "licenses_table"
        const val COLUMN_KEY = "key"
    }
}