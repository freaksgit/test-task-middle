package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local

import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class LocalRepositoryDataSource() : RepositoryDataSource {

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}