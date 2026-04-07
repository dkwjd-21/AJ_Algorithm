// 코드의 성능을 분석하기 위한 클래스
/**
 * [주의사항]
 * 본 클래스의 측정 결과는 로컬 환경(JVM Warm-up, 클래스 로딩 등)의 영향을 받으므로,
 * 백준(BOJ)이나 프로그래머스와 같은 온라인 저지 사이트의 실제 채점 결과와는
 * 시간 및 메모리 수치에서 차이가 발생할 수 있습니다.
 * * - 시간: 로컬 시스템 사양 및 JVM 초기화 오버헤드 포함 가능성
 * - 메모리: JVM 힙 메모리 사용량 기준 (서버는 프로세스 전체 점유 메모리 기준)
 * * 따라서 절대적인 수치보다는 코드 수정 전후의 '상대적인 성능 개선 지표'로 활용하세요.
 */

public class Analyzer {
    private static long startTime;

    /**
     * 성능 측정 시작
     */
    public static void start() {
        // 가비지 컬렉션을 명시적으로 호출하여 이전 작업의 메모리 영향을 최소화
        Runtime.getRuntime().gc();
        startTime = System.nanoTime();
    }

    /**
     * 성능 측정 종료 및 결과 출력 (ms와 sec 단위 병기)
     */
    public static void end() {
        long endTime = System.nanoTime();
        double durationNano = (double) (endTime - startTime);

        // 단위 변환 로직
        double durationMs = durationNano / 1_000_000.0;
        double durationSec = durationNano / 1_000_000_000.0;

        // 메모리 계산 (사용한 메모리 = 전체 - 여유)
        Runtime runtime = Runtime.getRuntime();
        double usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024.0);

        System.out.println("\n" + "=".repeat(15) + " PERFORMANCE " + "=".repeat(15));
        System.out.printf("⏱️  시간   : %.4f ms (%.4f 초)\n", durationMs, durationSec);
        System.out.printf("💾 메모리 : %.2f MB\n", usedMemory);
        System.out.println("=".repeat(43));
    }
}