package main.java.calculator;

import java.util.ArrayList;
import java.util.List;

// 연산자 기호 잘못된 경우 처리
class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String message) {
        super(message);
    }
}

// 나눗셈에서 분모 0인 경우 처리
class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    private List<Integer> results;

    /* static, final 활용 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */
    private static final List<Double> circleAreas = new ArrayList<>();

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public double calculateCircleArea(double radius) {
        if (radius <= 0) {
            System.out.println("반지름은 0보다 커야 합니다.");
            return 0;
        } else {
            return Math.PI * radius * radius;
        }
    }

    // throws : 이 메서드가 어떤 예외사항 던질 수 있는 알려줌
    public int calculate(int num1, int num2, char operator) throws InvalidOperatorException, DivisionByZeroException {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new DivisionByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new InvalidOperatorException("유효하지 않은 연산자 기호입니다.");
        }
        results.add(result);

        return result;
    }

    // Getter 메서드
    public List<Integer> getResults() {
        return results;
    }

    public static List<Double> getCircleAreas() {
        return circleAreas;
    }

    // Setter 메서드
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    // 가장 먼저 저장된 데이터 삭제하는 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    public void inquiryResults() {
        System.out.println("저장된 연산 결과: " + results);
    }
}
