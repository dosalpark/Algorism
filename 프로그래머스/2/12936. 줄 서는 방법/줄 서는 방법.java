import java.util.*;

class Solution {
    public int[] solution(int n, long k) {

        // 0! ~ n! 저장
        long[] f = new long[n + 1];
        f[0] = 1;
        // 줄 서야 하는 번호
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < f.length - 1; i++) {
            f[i + 1] = f[i] * (i + 1);
            list.add(i + 1);
        }

        // 결과 배열
        int[] result = new int[n];
        // 인덱스
        int idx = 0;
        // 0 ~ n - 1까지
        for (int i = 0; i < n; i++) {
            // 조건 만족 시 현재 인덱스 글자는 i + 1
            // 현재 위치 번호가 3이라고 하면
            // 이미 앞에 2 * (n - 1)! 만큼 줄을 선 상태
            // 나머지 자릿수도 계속 반복해서 진행
            if (k <= (i + 1) * f[n - 1]) {
                // 이미 카운트한 앞 번호 수 만큼 제거
                k -= i * f[n - 1];
                // 번호 저장
                result[idx++] = list.get(i);
                // 해방 번호 제거
                list.remove(i);
                // 자릿수 감소
                n--;
                // i 초기화
                i = -1;
            }
        }

        // 결과 반환
        return result;
    }
}