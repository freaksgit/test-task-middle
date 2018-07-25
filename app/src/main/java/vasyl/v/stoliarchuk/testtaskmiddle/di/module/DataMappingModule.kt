package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper.*
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RepositoryDataFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RetrofitLicenseFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RetrofitOwnerFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope

@Module
class DataMappingModule {

    @Provides
    @AppScope
    fun provideRepositoryDataFromRetrofitMapper(ownerFromRetrofitMapper: RetrofitOwnerFromRetrofitMapper,
                                                licenseFromRetrofitMapper: RetrofitLicenseFromRetrofitMapper): RepositoryDataFromRetrofitMapper =
            RepositoryDataFromRetrofitMapper(ownerFromRetrofitMapper, licenseFromRetrofitMapper)

    @Provides
    @AppScope
    fun provideOwnerFromRetrofitMapper(): RetrofitOwnerFromRetrofitMapper = RetrofitOwnerFromRetrofitMapper()

    @Provides
    @AppScope
    fun provideLicenseFromRetrofitMapper(): RetrofitLicenseFromRetrofitMapper = RetrofitLicenseFromRetrofitMapper()

    @Provides
    @AppScope
    fun provideLicenseFromRoomMapper(): LicenseFromRoomMapper = LicenseFromRoomMapper()

    @Provides
    @AppScope
    fun provideLicenseToRoomMapper(): LicenseToRoomMapper = LicenseToRoomMapper()

    @Provides
    @AppScope
    fun provideOwnerFromRoomMapper(): OwnerFromRoomMapper = OwnerFromRoomMapper()

    @Provides
    @AppScope
    fun provideOwnerToRoomMapper(): OwnerToRoomMapper = OwnerToRoomMapper()


    @Provides
    @AppScope
    fun provideRepositoryDataFromRoomMapper(): RepositoryDataFromRoomMapper = RepositoryDataFromRoomMapper()


    @Provides
    @AppScope
    fun provideRepositoryDataEmbeddedFromRoomMapper(repositoryDataFromRoomMapper: RepositoryDataFromRoomMapper,
                                                    licenseFromRoomMapper: LicenseFromRoomMapper,
                                                    ownerFromRoomMapper: OwnerFromRoomMapper): RepositoryDataEmbeddedFromRoomMapper =
            RepositoryDataEmbeddedFromRoomMapper(repositoryDataFromRoomMapper, licenseFromRoomMapper, ownerFromRoomMapper)

    @Provides
    @AppScope
    fun provideRepositoryDataToRoomMapper(): RepositoryDataToRoomMapper = RepositoryDataToRoomMapper()


    @Provides
    @AppScope
    fun provideRepositoryDataToRoomHolderMapper(repositoryDataToRoomMapper: RepositoryDataToRoomMapper,
                                                licenseToRoomMapper: LicenseToRoomMapper,
                                                ownerToRoomMapper: OwnerToRoomMapper): RepositoryDataToRoomHolderMapper =
            RepositoryDataToRoomHolderMapper(repositoryDataToRoomMapper, ownerToRoomMapper, licenseToRoomMapper)
}