package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Round;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class RacingGame {
    private final CarManager manager = new CarManager();
    private final Winners winners = new Winners();
    private final List<Round> rounds = new ArrayList<>();
    private int CAR_AMOUNT, ROUND_MAX;


    public RacingGame(String[] cars, int round) {
        this.CAR_AMOUNT = cars.length;
        this.ROUND_MAX = round;
        manager.createAndAddCars(cars);
    }


    public List<RoundDTO> getRoundDTO() {
        List<RoundDTO> roundDTO = new ArrayList<>();
        for (Round round : rounds) {
            roundDTO.add(round.toDTO());
        }

        return roundDTO;
    }

    public List<String> getWinners() {
        int finalRoundIndex = rounds.size() - 1;
        Round finalRound = rounds.get(finalRoundIndex);
        RoundDTO finalRoundDTO = finalRound.toDTO();

        return winners.getWinners(finalRoundDTO);
    }

    public void proceedGame() {
        for (int round = 1; round <= ROUND_MAX; round++) {
            playRound(round);
        }
    }

    
    // 라운드 진행 - car에게 각자 순서대로 이동 지시, 라운드 정보 저장
    private void playRound(int round) {
        manager.tryToMoveCar(CAR_AMOUNT);
        saveRoundStatus(round);
    }

    // 라운드 정보를 저장
    private void saveRoundStatus(int round) {
        List<CarDTO> result = manager.getRoundResult();
        rounds.add(new Round(round, result));
    }

}
