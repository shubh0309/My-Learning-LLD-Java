package DesignTicTacToe;

import DesignTicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

public class TicTacToe {
    Deque<Player> players;
    Board gameBoard;
    TicTacToe(){
        intializeGame();
    }

    public void intializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);
        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);
        players.add(player1);
        players.add(player2);
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpace = gameBoard.getFreeCells();
            if(freeSpace.isEmpty()){
                noWinner = false;
                continue;
            }
//            Read the user input
            System.out.println("Player : "+playerTurn.name+ " Enter row, column");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

//            Place the piece
            boolean pieceTypeSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if(!pieceTypeSuccessfully){
                System.out.println("Player can not insert the piece, try again ");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean winner = checkForWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }
        }

        return "Tie";
    }



    public boolean checkForWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagnalMatch = true;
        boolean antiDiagnalMatch = true;

//        check row
        for(int i =0 ;i< gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
                break;
            }
        }

        // check column
        for(int i =0 ;i< gameBoard.size;i++){
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType){
                columnMatch = false;
                break;
            }
        }

//        Check diagnal
        for(int i=0, j =0;i<gameBoard.size; i++, j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                diagnalMatch = false;
                break;
            }
        }

        //        Check antidiagnal
        for(int i=0, j = gameBoard.size-1; i<gameBoard.size; i++, j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                antiDiagnalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagnalMatch || antiDiagnalMatch;
    }
}



























