package inflearnthejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach");
    }

    @Test
    void create1() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create1()");
    }

    @Test
    @Disabled // 아직 어떻게 고쳐야할 지 모르는 경우 등에 사용.
    void create2() {
        System.out.println("create2()");
    }
}