package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity

import com.google.gson.annotations.SerializedName


data class RetrofitLicense(
         val key: String,
         val name: String? = null,
         val spdxId: String? = null,
         val url: String? = null,
         val nodeId: String? = null)