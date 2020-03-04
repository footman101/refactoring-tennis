package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    private String handleEven() {
        String result = "";
        switch (player1Score) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            default:
                result = "Deuce";
                break;

        }
        return result;
    }

    private String handleAdvantageOrWin() {
        String result = "";
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) result = "Advantage " + player1Name;
        else if (minusResult == -1) result = "Advantage " +  player2Name;
        else if (minusResult >= 2) result = "Win for " + player1Name;
        else result = "Win for " + player2Name;
        return result;
    }

    private String handleNormal() {
        String result = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                result += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    result += "Love";
                    break;
                case 1:
                    result += "Fifteen";
                    break;
                case 2:
                    result += "Thirty";
                    break;
                case 3:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return handleEven();
        }

        if (player1Score >= 4 || player2Score >= 4) {
            return handleAdvantageOrWin();
        }

        return handleNormal();
    }
}