package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity


data class RetrofitOwner(
        val login: String? = null,
        val id: Int = 0,
        val nodeId: String? = null,
        val avatarUrl: String? = null,
        val gravatarId: String? = null,
        val url: String? = null,
        val htmlUrl: String? = null,
        val followersUrl: String? = null,
        val followingUrl: String? = null,
        val gistsUrl: String? = null,
        val starredUrl: String? = null,
        val subscriptionsUrl: String? = null,
        val organizationsUrl: String? = null,
        val reposUrl: String? = null,
        val eventsUrl: String? = null,
        val receivedEventsUrl: String? = null,
        val type: String? = null,
        val siteAdmin: Boolean = false)