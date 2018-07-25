package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomOwner.TABLE_NAME)
data class RoomOwner(@ColumnInfo(name = "login") val login: String? = null,
                @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: Int,
                @ColumnInfo(name = "nodeId") val nodeId: String? = null,
                @ColumnInfo(name = "avatarUrl") val avatarUrl: String? = null,
                @ColumnInfo(name = "gravatarId") val gravatarId: String? = null,
                @ColumnInfo(name = "url") val url: String? = null,
                @ColumnInfo(name = "htmlUrl") val htmlUrl: String? = null,
                @ColumnInfo(name = "followersUrl") val followersUrl: String? = null,
                @ColumnInfo(name = "followingUrl") val followingUrl: String? = null,
                @ColumnInfo(name = "gistsUrl") val gistsUrl: String? = null,
                @ColumnInfo(name = "starredUrl") val starredUrl: String? = null,
                @ColumnInfo(name = "subscriptionsUrl") val subscriptionsUrl: String? = null,
                @ColumnInfo(name = "organizationsUrl") val organizationsUrl: String? = null,
                @ColumnInfo(name = "reposUrl") val reposUrl: String? = null,
                @ColumnInfo(name = "eventsUrl") val eventsUrl: String? = null,
                @ColumnInfo(name = "receivedEventsUrl") val receivedEventsUrl: String? = null,
                @ColumnInfo(name = "type") val type: String? = null,
                @ColumnInfo(name = "siteAdmin") val siteAdmin: Boolean = false) {

    companion object {
        const val TABLE_NAME = "owners_table"
        const val COLUMN_ID = "id"
    }
}