package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RepositoryDataFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RetrofitLicenseFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RetrofitOwnerFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope

@Module
class DataMappingModule {

    @Provides
    @AppScope
    fun provideRepositoryDataFromRetrofitMapper(ownerFromRetrofitMapper: RetrofitOwnerFromRetrofitMapper,
                                                licenseFromRetrofitMapper: RetrofitLicenseFromRetrofitMapper): RepositoryDataFromRetrofitMapper {
        return RepositoryDataFromRetrofitMapper(ownerFromRetrofitMapper, licenseFromRetrofitMapper)
    }

    @Provides
    @AppScope
    fun provideOwnerFromRetrofitMapper(): RetrofitOwnerFromRetrofitMapper {
        return RetrofitOwnerFromRetrofitMapper()
    }

    @Provides
    @AppScope
    fun provideLicenseFromRetrofitMapper(): RetrofitLicenseFromRetrofitMapper {
        return RetrofitLicenseFromRetrofitMapper()
    }
}