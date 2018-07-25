package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepositoryDataToRoomMapper : Function<RepositoryData, RoomRepositoryData> {

    override fun apply(repositoryData: RepositoryData): RoomRepositoryData = RoomRepositoryData(
            repositoryData.id,
            repositoryData.nodeId,
            repositoryData.name,
            repositoryData.fullName,
            repositoryData.owner?.let { it.id },
            repositoryData._private,
            repositoryData.htmlUrl,
            repositoryData.description,
            repositoryData.fork,
            repositoryData.url,
            repositoryData.forksUrl,
            repositoryData.keysUrl,
            repositoryData.collaboratorsUrl,
            repositoryData.teamsUrl,
            repositoryData.hooksUrl,
            repositoryData.issueEventsUrl,
            repositoryData.eventsUrl,
            repositoryData.assigneesUrl,
            repositoryData.branchesUrl,
            repositoryData.tagsUrl,
            repositoryData.blobsUrl,
            repositoryData.gitTagsUrl,
            repositoryData.gitRefsUrl,
            repositoryData.treesUrl,
            repositoryData.statusesUrl,
            repositoryData.languagesUrl,
            repositoryData.stargazersUrl,
            repositoryData.contributorsUrl,
            repositoryData.subscribersUrl,
            repositoryData.subscriptionUrl,
            repositoryData.commitsUrl,
            repositoryData.gitCommitsUrl,
            repositoryData.commentsUrl,
            repositoryData.issueCommentUrl,
            repositoryData.contentsUrl,
            repositoryData.compareUrl,
            repositoryData.mergesUrl,
            repositoryData.archiveUrl,
            repositoryData.downloadsUrl,
            repositoryData.issuesUrl,
            repositoryData.pullsUrl,
            repositoryData.milestonesUrl,
            repositoryData.notificationsUrl,
            repositoryData.labelsUrl,
            repositoryData.releasesUrl,
            repositoryData.deploymentsUrl,
            repositoryData.createdAt,
            repositoryData.updatedAt,
            repositoryData.pushedAt,
            repositoryData.gitUrl,
            repositoryData.sshUrl,
            repositoryData.cloneUrl,
            repositoryData.svnUrl,
            repositoryData.homepage,
            repositoryData.size,
            repositoryData.stargazersCount,
            repositoryData.watchersCount,
            repositoryData.language,
            repositoryData.hasIssues,
            repositoryData.hasProjects,
            repositoryData.hasDownloads,
            repositoryData.hasWiki,
            repositoryData.hasPages,
            repositoryData.forksCount,
            repositoryData.mirrorUrl,
            repositoryData.archived,
            repositoryData.openIssuesCount,
            repositoryData.license?.let { it.key },
            repositoryData.forks,
            repositoryData.openIssues,
            repositoryData.watchers,
            repositoryData.defaultBranch,
            repositoryData.score)
}