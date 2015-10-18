import javax.swing.*;

public class Field {
    private int nx,ny,cellSize;
    JFrame frame;

    public Field(int nx, int ny, int cellSize) {
        this.nx = nx;
        this.ny = ny;
        this.cellSize = cellSize;
        frame = new JFrame("Snake game");
    }
    private void crate(){


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 500);
        frame.setVisible(true);

        frame.setSize(nx*cellSize,ny*cellSize);
        System.out.println(frame.getMaximumSize());


    }

    public static void main(String[] args) {
        Field field = new Field(10,10, 35);
        field.crate();
        Integer ii = 1000;
        Integer jj = 2000;


        System.out.println(false^false);


    }
}
