package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepositoryDataFromRoomMapper : Function<RoomRepositoryData, RepositoryData> {
    override fun apply(rRepositoryData: RoomRepositoryData): RepositoryData = RepositoryData(
            rRepositoryData.id,
            rRepositoryData.nodeId,
            rRepositoryData.name,
            rRepositoryData.fullName,
            null,
            rRepositoryData._private,
            rRepositoryData.htmlUrl,
            rRepositoryData.description,
            rRepositoryData.fork,
            rRepositoryData.url,
            rRepositoryData.forksUrl,
            rRepositoryData.keysUrl,
            rRepositoryData.collaboratorsUrl,
            rRepositoryData.teamsUrl,
            rRepositoryData.hooksUrl,
            rRepositoryData.issueEventsUrl,
            rRepositoryData.eventsUrl,
            rRepositoryData.assigneesUrl,
            rRepositoryData.branchesUrl,
            rRepositoryData.tagsUrl,
            rRepositoryData.blobsUrl,
            rRepositoryData.gitTagsUrl,
            rRepositoryData.gitRefsUrl,
            rRepositoryData.treesUrl,
            rRepositoryData.statusesUrl,
            rRepositoryData.languagesUrl,
            rRepositoryData.stargazersUrl,
            rRepositoryData.contributorsUrl,
            rRepositoryData.subscribersUrl,
            rRepositoryData.subscriptionUrl,
            rRepositoryData.commitsUrl,
            rRepositoryData.gitCommitsUrl,
            rRepositoryData.commentsUrl,
            rRepositoryData.issueCommentUrl,
            rRepositoryData.contentsUrl,
            rRepositoryData.compareUrl,
            rRepositoryData.mergesUrl,
            rRepositoryData.archiveUrl,
            rRepositoryData.downloadsUrl,
            rRepositoryData.issuesUrl,
            rRepositoryData.pullsUrl,
            rRepositoryData.milestonesUrl,
            rRepositoryData.notificationsUrl,
            rRepositoryData.labelsUrl,
            rRepositoryData.releasesUrl,
            rRepositoryData.deploymentsUrl,
            rRepositoryData.createdAt,
            rRepositoryData.updatedAt,
            rRepositoryData.pushedAt,
            rRepositoryData.gitUrl,
            rRepositoryData.sshUrl,
            rRepositoryData.cloneUrl,
            rRepositoryData.svnUrl,
            rRepositoryData.homepage,
            rRepositoryData.size,
            rRepositoryData.stargazersCount,
            rRepositoryData.watchersCount,
            rRepositoryData.language,
            rRepositoryData.hasIssues,
            rRepositoryData.hasProjects,
            rRepositoryData.hasDownloads,
            rRepositoryData.hasWiki,
            rRepositoryData.hasPages,
            rRepositoryData.forksCount,
            rRepositoryData.mirrorUrl,
            rRepositoryData.archived,
            rRepositoryData.openIssuesCount,
            null,
            rRepositoryData.forks,
            rRepositoryData.openIssues,
            rRepositoryData.watchers,
            rRepositoryData.defaultBranch,
            rRepositoryData.score
    )
}