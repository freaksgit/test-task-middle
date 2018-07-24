package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource

import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

interface RepositoryDataSource {

    fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>>
}