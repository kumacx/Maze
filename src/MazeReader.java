import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MazeReader {
    private int rows;
    private int cols;
    private ArrayList<ArrayList<MazeCell>> maze = new ArrayList<>();
    private MazeCell start;
    private MazeCell end;

    public MazeReader(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            switch(scanner.next().charAt(0)){
                //wall
                case 'X':

                    break;
                //path
                case ' ':
                    break;
                //new row
                case '\n':
                    break;
                //start
                case 'S':
                    break;
                //end
                case 'E':
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public MazeCell getStart() {
        return start;
    }

    public MazeCell getEnd() {
        return end;
    }

    public MazeCell getCell(int row, int col) {
        return maze[row][col];
    }

    public MazeCell getCell(int[] pos) {
        return maze[pos[0]][pos[1]];
    }

    public MazeCell[][] getMaze() {
        return maze;
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j].isWall() ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public void printPath() {
        MazeCell current = end;
        while (current != null) {
            current.setPath(true);
            current = current.getParent();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j].isPath() ? "P " : (maze[i][j].isWall() ? "1 " : "0 "));
            }
            System.out.println();
        }
    }
}
