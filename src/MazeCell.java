public class MazeCell {
    private int row;
    private int col;
    private boolean isWall;
    private boolean isStart;
    private boolean isEnd;
    private boolean isVisited;
    private boolean isPath;
    private MazeCell parent;

    public MazeCell(int row, int col, boolean isWall) {
        this.row = row;
        this.col = col;
        this.isWall = isWall;
        this.isStart = false;
        this.isEnd = false;
        this.isVisited = false;
        this.isPath = false;
        this.parent = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWall() {
        return isWall;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public boolean isPath() {
        return isPath;
    }

    public MazeCell getParent() {
        return parent;
    }

    public void setWall(boolean isWall) {
        this.isWall = isWall;
    }

    public void setStart(boolean isStart) {
        this.isStart = isStart;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setPath(boolean isPath) {
        this.isPath = isPath;
    }

    public void setParent(MazeCell parent) {
        this.parent = parent;
    }

    public void reset() {
        isVisited = false;
        isPath = false;
        parent = null;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}
