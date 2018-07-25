package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity


data class RetrofitRepositoryDataPack(
        val totalCount: Int = 0,
        val incompleteResults: Boolean = false,
        val items: List<RetrofitRepositoryData>)