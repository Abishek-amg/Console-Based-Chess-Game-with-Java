import java.util.Scanner;

public class Chess {

    static char[][] board = new char[8][8];
    static boolean whiteTurn = true;

    public static void main(String[] args) {
        initBoard();
        Scanner sc = new Scanner(System.in);

        System.out.println("  ================================");
        System.out.println("       JAVA CONSOLE CHESS");
        System.out.println("  ================================");
        System.out.println("  White = UPPERCASE  Black = lowercase");
        System.out.println("  Enter moves like:  e2 e4");

        while (true) {
            printBoard();

            // Check for checkmate or stalemate BEFORE asking for move
            if (!hasAnyLegalMove(whiteTurn)) {
                if (isInCheck(whiteTurn)) {
                    System.out.println("\n  * CHECKMATE! " + (whiteTurn ? "Black" : "White") + " wins! *");
                } else {
                    System.out.println("\n  * STALEMATE! It's a draw! *");
                }
                break;
            }

            if (isInCheck(whiteTurn)) {
                System.out.println("  !! " + (whiteTurn ? "White" : "Black") + " is in CHECK !!");
            }

            System.out.println(whiteTurn ? "\n  White's turn (UPPERCASE)" : "\n  Black's turn (lowercase)");
            System.out.print("  Move (e.g. e2 e4) or quit: ");
            String input = sc.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("  Goodbye!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) { System.out.println("  Bad format! Try: e2 e4"); continue; }

            int[] from = toIndex(parts[0]);
            int[] to   = toIndex(parts[1]);
            if (from == null || to == null) { System.out.println("  Invalid square!"); continue; }

            int r1 = from[0], c1 = from[1];
            int r2 = to[0],   c2 = to[1];
            char piece = board[r1][c1];

            if (piece == '.') { System.out.println("  No piece there!"); continue; }
            if (whiteTurn && Character.isLowerCase(piece)) { System.out.println("  That's Black's piece!"); continue; }
            if (!whiteTurn && Character.isUpperCase(piece)) { System.out.println("  That's White's piece!"); continue; }

            char target = board[r2][c2];
            if (target != '.' && Character.isUpperCase(target) == whiteTurn) {
                System.out.println("  Can't capture your own piece!"); continue;
            }

            if (!isValidMove(r1, c1, r2, c2, piece)) {
                System.out.println("  Illegal move!"); continue;
            }

            // --- KEY: don't allow move that leaves own king in check ---
            char[][] backup = copyBoard();
            board[r2][c2] = piece;
            board[r1][c1] = '.';
            // Pawn promotion to Queen
            if (piece == 'P' && r2 == 0) board[r2][c2] = 'Q';
            if (piece == 'p' && r2 == 7) board[r2][c2] = 'q';

            if (isInCheck(whiteTurn)) {
                board = backup; // undo
                System.out.println("  That move leaves your king in check!"); continue;
            }

            whiteTurn = !whiteTurn;
        }

        sc.close();
    }

    // ─── CHECK DETECTION ──────────────────────────────────────────
    // Is the given side's king currently under attack?
    static boolean isInCheck(boolean white) {
        int[] king = findKing(white);
        if (king == null) return false;

        // Loop all enemy pieces, see if any can attack the king
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                char p = board[r][c];
                if (p == '.') continue;
                if (Character.isUpperCase(p) == white) continue; // skip own pieces
                if (isValidMove(r, c, king[0], king[1], p)) return true;
            }
        }
        return false;
    }

    // ─── CHECKMATE / STALEMATE ────────────────────────────────────
    // Does the given side have at least one legal move?
    static boolean hasAnyLegalMove(boolean white) {
        for (int r1 = 0; r1 < 8; r1++) {
            for (int c1 = 0; c1 < 8; c1++) {
                char p = board[r1][c1];
                if (p == '.' || Character.isUpperCase(p) != white) continue;

                // Try every possible destination
                for (int r2 = 0; r2 < 8; r2++) {
                    for (int c2 = 0; c2 < 8; c2++) {
                        char target = board[r2][c2];
                        if (target != '.' && Character.isUpperCase(target) == white) continue;
                        if (!isValidMove(r1, c1, r2, c2, p)) continue;

                        // Try the move, see if king is still in check
                        char[][] backup = copyBoard();
                        board[r2][c2] = p;
                        board[r1][c1] = '.';
                        boolean stillInCheck = isInCheck(white);
                        board = backup;

                        if (!stillInCheck) return true; // found a legal move
                    }
                }
            }
        }
        return false; // no legal move found
    }

    static int[] findKing(boolean white) {
        char king = white ? 'K' : 'k';
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                if (board[r][c] == king) return new int[]{r, c};
        return null;
    }

    // ─── MOVE RULES ───────────────────────────────────────────────
    static boolean isValidMove(int r1, int c1, int r2, int c2, char piece) {
        if (r1 == r2 && c1 == c2) return false;
        switch (Character.toUpperCase(piece)) {
            case 'P': return validPawn(r1, c1, r2, c2, piece);
            case 'R': return validRook(r1, c1, r2, c2);
            case 'N': return validKnight(r1, c1, r2, c2);
            case 'B': return validBishop(r1, c1, r2, c2);
            case 'Q': return validRook(r1, c1, r2, c2) || validBishop(r1, c1, r2, c2);
            case 'K': return validKing(r1, c1, r2, c2);
        }
        return false;
    }

    static boolean validPawn(int r1, int c1, int r2, int c2, char piece) {
        int dir = Character.isUpperCase(piece) ? -1 : 1;
        int startRow = Character.isUpperCase(piece) ? 6 : 1;
        if (c1 == c2 && r2 == r1+dir && board[r2][c2] == '.') return true;
        if (c1 == c2 && r1 == startRow && r2 == r1+2*dir
                && board[r1+dir][c1] == '.' && board[r2][c2] == '.') return true;
        if (Math.abs(c2-c1)==1 && r2==r1+dir && board[r2][c2]!='.') return true;
        return false;
    }

    static boolean validRook(int r1, int c1, int r2, int c2) {
        if (r1!=r2 && c1!=c2) return false;
        return pathClear(r1, c1, r2, c2);
    }

    static boolean validKnight(int r1, int c1, int r2, int c2) {
        int dr = Math.abs(r2-r1), dc = Math.abs(c2-c1);
        return (dr==2&&dc==1)||(dr==1&&dc==2);
    }

    static boolean validBishop(int r1, int c1, int r2, int c2) {
        if (Math.abs(r2-r1)!=Math.abs(c2-c1)) return false;
        return pathClear(r1, c1, r2, c2);
    }

    static boolean validKing(int r1, int c1, int r2, int c2) {
        return Math.abs(r2-r1)<=1 && Math.abs(c2-c1)<=1;
    }

    static boolean pathClear(int r1, int c1, int r2, int c2) {
        int dr = Integer.signum(r2-r1);
        int dc = Integer.signum(c2-c1);
        int r = r1+dr, c = c1+dc;
        while (r!=r2 || c!=c2) {
            if (board[r][c] != '.') return false;
            r+=dr; c+=dc;
        }
        return true;
    }

    // ─── HELPERS ──────────────────────────────────────────────────
    static char[][] copyBoard() {
        char[][] copy = new char[8][8];
        for (int i = 0; i < 8; i++) copy[i] = board[i].clone();

        return copy;
    }

    static int[] toIndex(String s) {
        if (s.length()!=2) return null;
        int col = s.charAt(0)-'a';
        int row = 8-(s.charAt(1)-'0');
        if (col<0||col>7||row<0||row>7) return null;
        return new int[]{row, col};
    }

    static void initBoard() {
        char[] backRow = {'r','n','b','q','k','b','n','r'};
        for (int c=0;c<8;c++) { board[0][c]=backRow[c]; board[1][c]='p'; }
        for (int r=2;r<6;r++) for (int c=0;c<8;c++) board[r][c]='.';
        for (int c=0;c<8;c++) { board[6][c]='P'; board[7][c]=Character.toUpperCase(backRow[c]); }
    }

    static void printBoard() {
        System.out.println("\n    a b c d e f g h");
        System.out.println("  +-----------------+");
        for (int r=0;r<8;r++) {
            System.out.print((8-r)+" | ");
            for (int c=0;c<8;c++) System.out.print(board[r][c]+" ");
            System.out.println("| "+(8-r));
        }
        System.out.println("  +-----------------+");
        System.out.println("    a b c d e f g h");
    }
}