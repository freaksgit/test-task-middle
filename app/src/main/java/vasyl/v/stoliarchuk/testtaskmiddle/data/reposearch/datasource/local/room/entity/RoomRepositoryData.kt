package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.*

@Entity(tableName = RoomRepositoryData.TABLE_NAME,
        foreignKeys = [
            ForeignKey(entity = RoomOwner::class,
                    parentColumns = [RoomOwner.COLUMN_ID],
                    childColumns = [RoomRepositoryData.COLUMN_OWNER_ID])],
        indices = [(Index(name = "IXFK_" + RoomRepositoryData.TABLE_NAME + "_" + RoomRepositoryData.COLUMN_OWNER_ID, value = [(RoomRepositoryData.COLUMN_OWNER_ID)])),
            (Index(name = "IXFK_" + RoomRepositoryData.TABLE_NAME + "_" + RoomRepositoryData.COLUMN_LICENSE_KEY, value = [(RoomRepositoryData.COLUMN_LICENSE_KEY)]))])
data class RoomRepositoryData(
        @PrimaryKey @ColumnInfo(name = COLUMN_ID) val id: Int,
        @ColumnInfo(name = "nodeId") val nodeId: String?,
        @ColumnInfo(name = COLUMN_NAME) val name: String?,
        @ColumnInfo(name = "full_name") val fullName: String?,
        @ColumnInfo(name = COLUMN_OWNER_ID) val ownerId: Int?,
        @ColumnInfo(name = "private") val _private: Boolean,
        @ColumnInfo(name = "html_url") val htmlUrl: String?,
        @ColumnInfo(name = "description") val description: String?,
        @ColumnInfo(name = "fork") val fork: Boolean,
        @ColumnInfo(name = "url") val url: String?,
        @ColumnInfo(name = "forks_url") val forksUrl: String?,
        @ColumnInfo(name = "keys_url") val keysUrl: String?,
        @ColumnInfo(name = "collaboratorsUrl") val collaboratorsUrl: String?,
        @ColumnInfo(name = "teamsUrl") val teamsUrl: String?,
        @ColumnInfo(name = "hooksUrl") val hooksUrl: String?,
        @ColumnInfo(name = "issueEventsUrl") val issueEventsUrl: String?,
        @ColumnInfo(name = "eventsUrl") val eventsUrl: String?,
        @ColumnInfo(name = "assigneesUrl") val assigneesUrl: String?,
        @ColumnInfo(name = "branchesUrl") val branchesUrl: String?,
        @ColumnInfo(name = "tagsUrl") val tagsUrl: String?,
        @ColumnInfo(name = "blobsUrl") val blobsUrl: String?,
        @ColumnInfo(name = "gitTagsUrl") val gitTagsUrl: String?,
        @ColumnInfo(name = "gitRefsUrl") val gitRefsUrl: String?,
        @ColumnInfo(name = "treesUrl") val treesUrl: String?,
        @ColumnInfo(name = "statusesUrl") val statusesUrl: String?,
        @ColumnInfo(name = "languagesUrl") val languagesUrl: String?,
        @ColumnInfo(name = "stargazersUrl") val stargazersUrl: String?,
        @ColumnInfo(name = "contributorsUrl") val contributorsUrl: String?,
        @ColumnInfo(name = "subscribersUrl") val subscribersUrl: String?,
        @ColumnInfo(name = "subscriptionUrl") val subscriptionUrl: String?,
        @ColumnInfo(name = "commitsUrl") val commitsUrl: String?,
        @ColumnInfo(name = "gitCommitsUrl") val gitCommitsUrl: String?,
        @ColumnInfo(name = "commentsUrl") val commentsUrl: String?,
        @ColumnInfo(name = "issueCommentUrl") val issueCommentUrl: String?,
        @ColumnInfo(name = "contentsUrl") val contentsUrl: String?,
        @ColumnInfo(name = "compareUrl") val compareUrl: String?,
        @ColumnInfo(name = "mergesUrl") val mergesUrl: String?,
        @ColumnInfo(name = "archiveUrl") val archiveUrl: String?,
        @ColumnInfo(name = "downloadsUrl") val downloadsUrl: String?,
        @ColumnInfo(name = "issuesUrl") val issuesUrl: String?,
        @ColumnInfo(name = "pullsUrl") val pullsUrl: String?,
        @ColumnInfo(name = "milestonesUrl") val milestonesUrl: String?,
        @ColumnInfo(name = "notificationsUrl") val notificationsUrl: String?,
        @ColumnInfo(name = "labelsUrl") val labelsUrl: String?,
        @ColumnInfo(name = "releasesUrl") val releasesUrl: String?,
        @ColumnInfo(name = "deploymentsUrl") val deploymentsUrl: String?,
        @ColumnInfo(name = "createdAt") val createdAt: String?,
        @ColumnInfo(name = "updatedAt") val updatedAt: String?,
        @ColumnInfo(name = "pushedAt") val pushedAt: String?,
        @ColumnInfo(name = "gitUrl") val gitUrl: String?,
        @ColumnInfo(name = "sshUrl") val sshUrl: String?,
        @ColumnInfo(name = "cloneUrl") val cloneUrl: String?,
        @ColumnInfo(name = "svnUrl") val svnUrl: String?,
        @ColumnInfo(name = "homepage") val homepage: String?,
        @ColumnInfo(name = "size") val size: Int,
        @ColumnInfo(name = "stargazersCount") val stargazersCount: Int,
        @ColumnInfo(name = "watchersCount") val watchersCount: Int,
        @ColumnInfo(name = "language") val language: String?,
        @ColumnInfo(name = "hasIssues") val hasIssues: Boolean,
        @ColumnInfo(name = "hasProjects") val hasProjects: Boolean,
        @ColumnInfo(name = "hasDownloads") val hasDownloads: Boolean,
        @ColumnInfo(name = "hasWiki") val hasWiki: Boolean,
        @ColumnInfo(name = "hasPages") val hasPages: Boolean,
        @ColumnInfo(name = "forksCount") val forksCount: Int,
        @ColumnInfo(name = "mirrorUrl") val mirrorUrl: String?,
        @ColumnInfo(name = "archived") val archived: Boolean,
        @ColumnInfo(name = "openIssuesCount") val openIssuesCount: Int,
        @ColumnInfo(name = COLUMN_LICENSE_KEY) val licenseKey: String?,
        @ColumnInfo(name = "forks") val forks: Int,
        @ColumnInfo(name = "openIssues") val openIssues: Int,
        @ColumnInfo(name = "watchers") val watchers: Int,
        @ColumnInfo(name = "defaultBranch") val defaultBranch: String?,
        @ColumnInfo(name = "score") val score: Double?) {


    companion object {
        const val TABLE_NAME = "repositories_table"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_LICENSE_KEY = "licenseKey"
        const val COLUMN_OWNER_ID = "ownerId"
    }
}