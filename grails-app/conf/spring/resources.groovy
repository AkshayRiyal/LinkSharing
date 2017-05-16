import java.util.concurrent.Executors
import grails.plugins.executor.PersistenceContextExecutorWrapper
beans = {
    executorService(PersistenceContextExecutorWrapper) { bean ->
        bean.destroyMethod = 'destroy'
        persistenceInterceptor = ref("persistenceInterceptor")
        executor = Executors.newCachedThreadPool()
    }
}