package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity

import com.google.gson.annotations.SerializedName

data class RetrofitRepositoryData(
         val id: Int = 0,
         val nodeId: String? = null,
         val name: String? = null,
         val fullName: String? = null,
         val owner: RetrofitOwner? = null,
        @SerializedName("private") val _private: Boolean = false,
         val htmlUrl: String? = null,
         val description: String? = null,
         val fork: Boolean = false,
         val url: String? = null,
         val forksUrl: String? = null,
         val keysUrl: String? = null,
         val collaboratorsUrl: String? = null,
         val teamsUrl: String? = null,
         val hooksUrl: String? = null,
         val issueEventsUrl: String? = null,
         val eventsUrl: String? = null,
         val assigneesUrl: String? = null,
         val branchesUrl: String? = null,
         val tagsUrl: String? = null,
         val blobsUrl: String? = null,
         val gitTagsUrl: String? = null,
         val gitRefsUrl: String? = null,
         val treesUrl: String? = null,
         val statusesUrl: String? = null,
         val languagesUrl: String? = null,
         val stargazersUrl: String? = null,
         val contributorsUrl: String? = null,
         val subscribersUrl: String? = null,
         val subscriptionUrl: String? = null,
         val commitsUrl: String? = null,
         val gitCommitsUrl: String? = null,
         val commentsUrl: String? = null,
         val issueCommentUrl: String? = null,
         val contentsUrl: String? = null,
         val compareUrl: String? = null,
         val mergesUrl: String? = null,
         val archiveUrl: String? = null,
         val downloadsUrl: String? = null,
         val issuesUrl: String? = null,
         val pullsUrl: String? = null,
         val milestonesUrl: String? = null,
         val notificationsUrl: String? = null,
         val labelsUrl: String? = null,
         val releasesUrl: String? = null,
         val deploymentsUrl: String? = null,
         val createdAt: String? = null,
         val updatedAt: String? = null,
         val pushedAt: String? = null,
         val gitUrl: String? = null,
         val sshUrl: String? = null,
         val cloneUrl: String? = null,
         val svnUrl: String? = null,
         val homepage: String? = null,
         val size: Int = 0,
         val stargazersCount: Int = 0,
         val watchersCount: Int = 0,
         val language: String? = null,
         val hasIssues: Boolean = false,
         val hasProjects: Boolean = false,
         val hasDownloads: Boolean = false,
         val hasWiki: Boolean = false,
         val hasPages: Boolean = false,
         val forksCount: Int = 0,
         val mirrorUrl: String? = null,
         val archived: Boolean = false,
         val openIssuesCount: Int = 0,
         val license: RetrofitLicense? = null,
         val forks: Int = 0,
         val openIssues: Int = 0,
         val watchers: Int = 0,
         val defaultBranch: String? = null,
         val score: Double? = null) 