package tw.roy.deng.cathay

object AppInitializerProvider {
    fun get(): AppInitializer = AppInitializerImpl()
}