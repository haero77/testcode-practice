package inflearnthejavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // 언더스코어를 빈 공백으로 치환
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

    @DisplayName("스터디 만들기")
    @Test
    void create_new_study_again() { // 테스트 메서드 식별자는 snake_case 를 사용하라.
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create1()");
    }

    @Test
    @Disabled
        // 아직 어떻게 고쳐야할 지 모르는 경우 등에 사용.
    void create2() {
        System.out.println("create2()");
    }
}