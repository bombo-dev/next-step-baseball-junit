package baseball;

public class BaseBallGame implements Game {
    GameStatus status;
    GameNumber number;

    public BaseBallGame() {
        this.status = GameStatus.START;
    }

    @Override
    public void play() {
        initNumber();
    }

    private boolean isEnd() {
        return status == GameStatus.END;
    }

    private void initNumber() {
        number = new GameNumber();
    }
}
