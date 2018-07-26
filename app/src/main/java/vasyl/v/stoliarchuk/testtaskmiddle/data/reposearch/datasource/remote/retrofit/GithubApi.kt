package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit

import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryDataPack

interface GithubApi {

    @GET(GET_REPOS_BY_TEXT)
    fun getRepositoriesByText(@Query("q") queryText: String): Maybe<RetrofitRepositoryDataPack>


    companion object {
        const val BASE_URL = "https://api.github.com"

        const val GET_REPOS_BY_TEXT = "/search/repositories"
    }
}