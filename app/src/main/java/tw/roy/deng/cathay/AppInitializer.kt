package tw.roy.deng.cathay

interface AppInitializer {
    fun init(app: CathayApplication)
}

open class AppInitializerImpl : AppInitializer {
    override fun init(app: CathayApplication) {

    }
}