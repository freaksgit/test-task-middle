package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs.PreferenceDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs.PreferenceRepository
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.RepoRepository
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.LocalRepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.GithubDatabase
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper.RepositoryDataEmbeddedFromRoomMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper.RepositoryDataToRoomHolderMapper
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.RemoteRepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.GithubApi
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper.RepositoryDataFromRetrofitMapper
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.DiNames
import javax.inject.Named


@Module
class DataModule {

    @Provides
    @AppScope
    fun provideSharedPreferences(@Named(DiNames.APP_CONTEXT) context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @AppScope
    fun providePreferenceDataSource(sharedPreferences: SharedPreferences): PreferenceDataSource {
        return PreferenceRepository(sharedPreferences)
    }

    @Provides
    @AppScope
    fun provideGithubDatabase(@Named(DiNames.APP_CONTEXT) context: Context): GithubDatabase {
        return GithubDatabase.getInstance(context)!!
    }

    @Provides
    @AppScope
    @Named(DiNames.LOCAL)
    fun provideLocalRepositoryDataSource(githubDatabase: GithubDatabase,
                                         repositoryDataEmbeddedFromRoomMapper: RepositoryDataEmbeddedFromRoomMapper,
                                         repositoryDataToRoomHolderMapper: RepositoryDataToRoomHolderMapper): RepositoryDataSource {
        return LocalRepositoryDataSource(githubDatabase, repositoryDataEmbeddedFromRoomMapper, repositoryDataToRoomHolderMapper)
    }


    @Provides
    @AppScope
    @Named(DiNames.REMOTE)
    fun provideRemoteRepositoryDataSource(githubApi: GithubApi,
                                          repositoryDataFromRetrofitMapper: RepositoryDataFromRetrofitMapper): RepositoryDataSource {
        return RemoteRepositoryDataSource(githubApi, repositoryDataFromRetrofitMapper)
    }

    @Provides
    @AppScope
    @Named(DiNames.REPOSITORY)
    fun provideRepoRepository(@Named(DiNames.LOCAL) localRepositoryDataSource: RepositoryDataSource,
                              @Named(DiNames.REMOTE) remoteRepositoryDataSource: RepositoryDataSource,
                              preferenceDataSource: PreferenceDataSource): RepositoryDataSource {
        return RepoRepository(localRepositoryDataSource, remoteRepositoryDataSource, preferenceDataSource)
    }


}