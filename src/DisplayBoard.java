
public class DisplayBoard {
    private String boardToString;

    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_RESET = "\u001B[0m";

    public DisplayBoard(String boardToString) {
        this.boardToString = boardToString;
    }

    public void displayBoard() {
        char[] charList = boardToString.toCharArray();

        for (char singleChar : charList) {
            switch(singleChar) {
                case '#':
                    System.out.print("\u001B[47m" + "  " + "\u001B[0m");
                    break;
                case '/':
                    System.out.print("  ");
                    break;
                case '$':
                    System.out.print("\u001B[42m" + "  " + "\u001B[0m");
                    break;
                case ' ':
                    System.out.print("\u001B[44m" + "  " + "\u001B[0m");
                    break;
                case '-':
                    System.out.print("  ");
                    break;
                case '%':
                    System.out.print("\u001B[47m" + "  " + "\u001B[0m");
                    break;
                case '0':
                    System.out.print("10");
                    break;
                case ';':
                    System.out.print("\n");
                    break;
                default:
                    System.out.print(" " + singleChar);            
            }
        }
    }
}