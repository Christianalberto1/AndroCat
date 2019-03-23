package mustafaozhan.github.com.androcat.tools

import mustafaozhan.github.com.androcat.base.api.github.GitHubApiHelper
import mustafaozhan.github.com.androcat.model.Settings
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mustafa Ozhan on 2018-07-22.
 */
@Singleton
class DataManager @Inject
constructor(private val generalSharedPreferences: GeneralSharedPreferences) {

    @Inject
    lateinit var gitHubApiHelper: GitHubApiHelper

    fun loadUser() = generalSharedPreferences.loadUser()

    fun updateUser(username: String? = null, isLoggedIn: Boolean? = null, token: String? = null) =
        generalSharedPreferences.updateUser(username, isLoggedIn, token)

    fun loadSettings() = generalSharedPreferences.loadSettings()

    fun updateSettings(settings: Settings) =
        generalSharedPreferences.persistSettings(settings)

    fun getUser(token: String?) = gitHubApiHelper.gitHubApiServices.getUser(token)
}