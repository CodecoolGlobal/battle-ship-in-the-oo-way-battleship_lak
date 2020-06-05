import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

public class GameBoard {
    private Ocean oceanOne;
    private Ocean oceanTwo;

    private String boardBorder = "#";
    private String oceanBorder = "%";
    private String interPause = "-#-";
    private String pause = "-";
    private String doublePause = "--";
    private String tripplePause = "---";
    private String leftPause = "///";
    private String letters = "ABCDEFGHIJ";
    private String horizontalOceanBorder = "%%%%%%%%%%%%";

    public GameBoard(Ocean playerOne, Ocean playerTwo) {
        this.oceanOne = playerOne;
        this.oceanTwo = playerTwo;
    }

    public String createTopAndBottomLine() {
        StringBuilder topAndBottomLine = new StringBuilder();
        topAndBottomLine.append(leftPause);
        for(int i = 1; i < 34; i++) {
            topAndBottomLine.append(boardBorder);
        }
        topAndBottomLine.append("\n");

        return topAndBottomLine.toString();
    }

    public String createEmptyLine() {
        StringBuilder emptyLine = new StringBuilder();
        emptyLine.append(leftPause);
        emptyLine.append(boardBorder);
        for(int i = 1; i < 16; i++) {
            emptyLine.append(pause);
        }
        emptyLine.append(boardBorder);
        for(int i = 1; i < 16; i++) {
            emptyLine.append(pause);
        }
        emptyLine.append(boardBorder);
        emptyLine.append("\n");

        return emptyLine.toString();
    }

    public String createTitleLine() {
        StringBuilder titleLine = new StringBuilder();
        titleLine.append(leftPause + boardBorder + tripplePause + pause + "PLAYER_1" + doublePause);
        titleLine.append(interPause);
        titleLine.append(tripplePause + "PLAYER_2" + tripplePause + boardBorder);
        titleLine.append("\n");

        return titleLine.toString();
    }

    public String createLetterLine() {
        StringBuilder letterLine = new StringBuilder();
        letterLine.append(leftPause + boardBorder + tripplePause + letters + pause);
        letterLine.append(interPause);
        letterLine.append(doublePause + letters + doublePause + boardBorder);
        letterLine.append("\n");

        return letterLine.toString();
    }

    public String createHashtagLine() {
        StringBuilder hashtagLine = new StringBuilder();
        hashtagLine.append(leftPause + boardBorder + doublePause + horizontalOceanBorder);
        hashtagLine.append(interPause);
        hashtagLine.append(pause + horizontalOceanBorder + pause + boardBorder);
        hashtagLine.append("\n");
        
        return hashtagLine.toString();
    }

    public List<String> createOceanLines() {
        List<String> allOceanLines = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
            
            List<Square> singleLineOceanOne = new ArrayList<>();
            singleLineOceanOne = (oceanOne.getSquares().get(i));
            List<Square> singleLineOceanTwo = new ArrayList<>();
            singleLineOceanTwo = (oceanTwo.getSquares().get(i));
            
            StringBuilder fullSingleOceanLine = new StringBuilder();
            
            if(i < 9) {
                fullSingleOceanLine.append(leftPause + boardBorder + pause + (i + 1) + oceanBorder);
            } else {
                fullSingleOceanLine.append(leftPause + boardBorder + pause + "=" + oceanBorder);
            }
            for(int j = 0; j < 10; j++) {
                fullSingleOceanLine.append(singleLineOceanOne.get(j).toString());
            }

            if(i < 9) {
                fullSingleOceanLine.append(oceanBorder + interPause + (i + 1) + oceanBorder);
            } else {
                fullSingleOceanLine.append(oceanBorder +  interPause + "=" + oceanBorder);
            }           
            for(int k = 0; k < 10; k++) {
                fullSingleOceanLine.append(singleLineOceanTwo.get(k).toString());
            }
            fullSingleOceanLine.append(oceanBorder + pause + boardBorder + "\n");
            
            allOceanLines.add(fullSingleOceanLine.toString());
        }
        
        return allOceanLines;
    }

    public String toString() {
        StringBuilder mainString = new StringBuilder();
        
        mainString.append(createTopAndBottomLine());
        mainString.append(createEmptyLine());
        mainString.append(createTitleLine());        
        mainString.append(createEmptyLine());
        mainString.append(createLetterLine());
        mainString.append(createHashtagLine());

        List<String> oceanLines = new ArrayList<>();
        oceanLines = createOceanLines();

        for(int i = 0; i < 10; i++) {
            mainString.append(oceanLines.get(i));
        }

        mainString.append(createHashtagLine());
        mainString.append(createEmptyLine());
        mainString.append(createTopAndBottomLine());

        return mainString.toString();
    }   
}