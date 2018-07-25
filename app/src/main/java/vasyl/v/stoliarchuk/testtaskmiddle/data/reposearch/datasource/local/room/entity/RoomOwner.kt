package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomOwner.TABLE_NAME)
data class RoomOwner(@ColumnInfo(name = "login") var login: String? = null,
                @PrimaryKey @ColumnInfo(name = COLUMN_ID) var id: Int,
                @ColumnInfo(name = "nodeId") var nodeId: String? = null,
                @ColumnInfo(name = "avatarUrl") var avatarUrl: String? = null,
                @ColumnInfo(name = "gravatarId") var gravatarId: String? = null,
                @ColumnInfo(name = "url") var url: String? = null,
                @ColumnInfo(name = "htmlUrl") var htmlUrl: String? = null,
                @ColumnInfo(name = "followersUrl") var followersUrl: String? = null,
                @ColumnInfo(name = "followingUrl") var followingUrl: String? = null,
                @ColumnInfo(name = "gistsUrl") var gistsUrl: String? = null,
                @ColumnInfo(name = "starredUrl") var starredUrl: String? = null,
                @ColumnInfo(name = "subscriptionsUrl") var subscriptionsUrl: String? = null,
                @ColumnInfo(name = "organizationsUrl") var organizationsUrl: String? = null,
                @ColumnInfo(name = "reposUrl") var reposUrl: String? = null,
                @ColumnInfo(name = "eventsUrl") var eventsUrl: String? = null,
                @ColumnInfo(name = "receivedEventsUrl") var receivedEventsUrl: String? = null,
                @ColumnInfo(name = "type") var type: String? = null,
                @ColumnInfo(name = "siteAdmin") var siteAdmin: Boolean = false) {

    companion object {
        const val TABLE_NAME = "owners_table"
        const val COLUMN_ID = "id"
    }
}