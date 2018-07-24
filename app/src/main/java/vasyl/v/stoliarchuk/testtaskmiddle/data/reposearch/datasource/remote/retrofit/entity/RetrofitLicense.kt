package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity

import com.google.gson.annotations.SerializedName


data class RetrofitLicense(
        @SerializedName("key") val key: String? = null,
        @SerializedName("name") val name: String? = null,
        @SerializedName("spdx_id") val spdxId: String? = null,
        @SerializedName("url") val url: String? = null,
        @SerializedName("node_id") val nodeId: String? = null)