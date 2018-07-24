package vasyl.v.stoliarchuk.testtaskmiddle

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vasyl.v.stoliarchuk.testtaskmiddle.di.component.DaggerAppComponent

class App : DaggerApplication() {



    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
            val appComponent = DaggerAppComponent.builder()
                    .application(this)
                    .build()
            appComponent.inject(this)
            return appComponent
    }


}