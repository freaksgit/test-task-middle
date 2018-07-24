package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideApplication(app: Application): Application = app

}