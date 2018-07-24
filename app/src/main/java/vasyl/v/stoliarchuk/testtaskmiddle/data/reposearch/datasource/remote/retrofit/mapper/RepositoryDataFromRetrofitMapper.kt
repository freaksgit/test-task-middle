package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData


class RepositoryDataFromRetrofitMapper:Function<RetrofitRepositoryData, RepositoryData>{
    override fun apply(t: RetrofitRepositoryData): RepositoryData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}