package ttt;

import java.util.*;
public class TTT {

    private char[][] board;
    private char currentPlayerMark;

    public TTT() {
        board = new char[3][3];
        currentPlayerMark = 'x';
        arxikopoihsh();
    }

    //kathe fora mas deixnei poios paixths paizei
    // afto den to skeftika egw mou to edeikse enas filos afou den borousa na allazw paixth kathe fora
    public char getCurrentPlayerMark()
    {
        return currentPlayerMark;
    }


    // kathe fora ftianxw ton pinaka
    public void arxikopoihsh() {

        
        for (int i = 0; i < 3; i++) {

            
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }


    // ektypwnei ton trexwn pinaka kathe fora
    public void ektypwsipinaka() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    //koitaw ola ta kelia kai an estw kai ena einai adeio(dhl an exei pavla) epistrefw false
    // allis o pinakas einai full
        public boolean fullareopinakas() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }


    // epistrefei true an kapoios nikhse alliws false
    // kalei kaitis alles synarthseis gia na elgxoun seires sthles
    public boolean elegxosnikhs() {
        return (tsekareseires() || tsekaresthles() || tsekarediagwnious());
    }


    // afto koitaei an uparxei nikhths stis seires
    private boolean tsekareseires() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }


    // afto koitaei an uparxei nikhths stis sthles
    private boolean tsekaresthles() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


    // edw tsekarei tis diagwnious kai epistrefei true an kapoios nikhse
    private boolean tsekarediagwnious() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }


    // tsekarei an kai oi 3 times einai idies gia na yparksei nikh
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }


    // allazei ta symvola twn paixtwn
    public void allaksepaixti() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        }
        else {
            currentPlayerMark = 'x';
        }
    }

    // vazei to shmadi tou kathe paixth sto katallhlo keli
    public boolean placeMark(int row, int col) {

        // prepei na elegksw an h thesh eina idiathesimh
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }

        return false;
    }

public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        TTT game = new TTT();
        game.arxikopoihsh();
        System.out.println("Kalosorisate sthn triliza");
        do
        {
            System.out.println("o trexwn pinakas:");
            game.ektypwsipinaka();
            int row;
            int col;
            do
            {
                System.out.println("o paixths " + game.getCurrentPlayerMark() + ",na dialeksei mia adeia seira kai na valei to shmadi tou");
                row = in.nextInt()-1;
                col = in.nextInt()-1;
            }
            while (!game.placeMark(row, col));
            game.allaksepaixti();
        }
        while(!game.elegxosnikhs() && !game.fullareopinakas());
        if (game.fullareopinakas() && !game.elegxosnikhs())
        {
            System.out.println("ISOPALIA");
        }
        else
        {
            System.out.println("o trexwn pinakas:");
            game.ektypwsipinaka();
            game.allaksepaixti();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Wins!");
        }
    }
}