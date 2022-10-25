package inflearnthejavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
        Study study = new Study(10);
        assertNotNull(study);
        System.out.println("create1()");
    }

    @Test
    @Disabled
        // 아직 어떻게 고쳐야할 지 모르는 경우 등에 사용.
    void create2() {
        System.out.println("create2()");
    }

    @Test
    @DisplayName("스터디 만들기")
    void Assertion_assertEquals() {
        Study study = new Study(10);
        assertNotNull(study);

        // 1. message 로 그냥 문자열만 사용하는 경우: 테스트 실패여부와 상관없이 매번 연산
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                "스터디를 처음 만들면 " + StudyStatus.DRAFT + "상태다.");

        // 2. message로 람다를 사용하는 경우:
        // - 테스트 실패 시에만 연산.
        // - 문자열 연산의 비용이 걱정되는 경우에는 람다식을 쓰는 것이 좋다.,
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + "상태다.");

//        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
//            @Override
//            public String get() {
//                return "스터디를 처음 만들면 DRAFT 상태다.";
//            }
//        });
    }

    // assertAll
    @Test
    void Assertion_assertAll() {
        Study study = new Study(-10);

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT + "상태다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

    // assertThrows
    @Test
    void Assertion_assertThrows() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야한다.", exception.getMessage());
    }

    // assertTimeout
    @Test
    void Assertion_assertTimeout() {
//        assertTimeout(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });

        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });

        // TODO ThreadLocal 알아보기
    }
}