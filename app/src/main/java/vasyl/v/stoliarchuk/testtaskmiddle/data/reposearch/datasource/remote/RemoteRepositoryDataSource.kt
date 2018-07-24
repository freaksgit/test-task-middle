package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote

import io.reactivex.Maybe
import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.GithubApi
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RemoteRepositoryDataSource(private val githubApi: GithubApi, private val fromRetrofitMapper: Function<RetrofitRepositoryData, RepositoryData>) : RepositoryDataSource {

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}