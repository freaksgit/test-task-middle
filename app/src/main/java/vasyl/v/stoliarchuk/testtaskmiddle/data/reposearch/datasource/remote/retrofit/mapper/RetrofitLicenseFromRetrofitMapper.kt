package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License

class RetrofitLicenseFromRetrofitMapper : Function<RetrofitLicense, License> {
    override fun apply(rLicense: RetrofitLicense): License {
        return License(
                rLicense.key,
                rLicense.name,
                rLicense.spdxId,
                rLicense.url,
                rLicense.nodeId)
    }
}