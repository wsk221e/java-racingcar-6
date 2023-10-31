package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarDTO;

public class Car {
    private final String name;
    private final Position position = new Position();

    public Car(String name) {
        this.name = name;
    }


    public CarDTO toDTO() {
        String name = this.name;
        int pos = position.getPosition();

        return new CarDTO(name, pos);
    }

    public void tryMove() {
        if (canMove()) {
            position.moveForward();
        }
    }


    // 랜덤으로 뽑은 값이 임계값보다 큰지(이동해도 되는지) 판별
    private boolean canMove() {
        int MOVE_THRESHOLD = 3;
        int pickedNumber = generateRandomNumber();

        return pickedNumber > MOVE_THRESHOLD;
    }

    // 범위를 정하고 그 안에서 랜덤 값 생성
    private int generateRandomNumber() {
        int RANGE_MIN = 0;
        int RANGE_MAX = 9;
        int number = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);

        return number;
    }

}
