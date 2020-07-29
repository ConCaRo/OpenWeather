package trong.ccr.weather

import org.junit.Before
import org.mockito.MockitoAnnotations

abstract class BaseTest {
    @Before
    open fun init() {
        MockitoAnnotations.initMocks(this)
    }
}