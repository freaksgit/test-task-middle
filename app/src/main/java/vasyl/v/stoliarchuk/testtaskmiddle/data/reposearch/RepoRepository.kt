package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch

import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepoRepository : RepositoryDataSource{

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}