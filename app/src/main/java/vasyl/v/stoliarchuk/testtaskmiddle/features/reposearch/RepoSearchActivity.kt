package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import vasyl.v.stoliarchuk.testtaskmiddle.R
import javax.inject.Inject

class RepoSearchActivity : DaggerAppCompatActivity(), RepoSearchContract.View {

    @Inject
    lateinit var presenter: RepoSearchContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.subscribe()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}
