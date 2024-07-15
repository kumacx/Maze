import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setResizable(true);

        // Create and set the menu bar
        JMenuBar menuBar = createMenuBar();
        frame.setJMenuBar(menuBar);

        // Create the split pane with initial split percentage
        JSplitPane finalSplitPane = createSplitPane(frame);

        // Add main panel to frame
        frame.getContentPane().add(finalSplitPane);

        frame.setVisible(true);
    }

    private static JSplitPane createSplitPane(JFrame frame) {
        // Create a panel for buttons on the left (initially visible)
        JPanel buttonPanel = createButtonPanel();

        // Create a panel for the maze on the right
        JPanel mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw a simple maze (for illustration)
                g.drawRect(50, 50, 200, 200);
                g.drawLine(50, 50, 250, 250);
                g.drawLine(250, 50, 50, 250);
            }
        };
        mazePanel.setPreferredSize(new Dimension(600, 600));

        // Create a button to toggle the left panel visibility
        JButton toggleButton = new JButton("<");

        // Create a panel for the toggle button
        JPanel togglePanel = new JPanel();
        togglePanel.setLayout(new GridLayout(1, 1, 1, 1));
        togglePanel.add(toggleButton);

        // Create a JSplitPane to split the window into toggle and button components
        JSplitPane innerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, togglePanel, buttonPanel);
        innerSplitPane.setDividerLocation(60);
        innerSplitPane.setEnabled(false);

        // Create a JSplitPane to split the inner split pane and the maze panel
        JSplitPane finalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, innerSplitPane, mazePanel);
        finalSplitPane.setDividerLocation(260);
        finalSplitPane.setEnabled(false);

        // Add action listener to toggle button
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleLeftPanel(innerSplitPane, finalSplitPane);
                toggleButton.setText(innerSplitPane.getRightComponent() != null ? "<" : ">");
            }
        });

        return finalSplitPane;
    }

    private static void toggleLeftPanel(JSplitPane innerSplitPane, JSplitPane finalSplitPane) {
        if (innerSplitPane.getRightComponent() != null) {
            // Collapse the left panel
            innerSplitPane.setRightComponent(null);
            innerSplitPane.setDividerLocation(60);
            finalSplitPane.setDividerLocation(60);
        } else {
            // Expand the left panel
            JPanel buttonPanel = createButtonPanel(); // Recreate button panel
            innerSplitPane.setRightComponent(buttonPanel);
            innerSplitPane.setDividerLocation(60);
            finalSplitPane.setDividerLocation(260);
        }
    }

    private static JPanel createButtonPanel() {
        // Create a panel for buttons on the left
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with gaps

        // Create and add buttons to the button panel
        JButton solveButton = new JButton("Solve");
        JButton startButton = new JButton("Set Start");
        JButton endButton = new JButton("Set End");
        buttonPanel.add(solveButton);
        buttonPanel.add(startButton);
        buttonPanel.add(endButton);

        return buttonPanel;
    }

    private static JMenuBar createMenuBar() {
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu loadMenu = new JMenu("Load File");
        JMenu saveMenu = new JMenu("Save File");
        JMenu algorithmMenu = new JMenu("Change Algorithm");
        JMenu helpMenu = new JMenu("Help");

        // Create menu items
        JMenuItem openItem = new JMenuItem("Open Maze");
        JMenuItem saveTXTItem = new JMenuItem("Save to TXT file");
        JMenuItem savePNGItem = new JMenuItem("Save to PNG file");

        JMenuItem randomAlgItem = new JMenuItem("Random Algorithm");
        JMenuItem bfsAlgItem = new JMenuItem("BFS Algorithm");
        JMenuItem dfsAlgItem = new JMenuItem("DFS Algorithm");

        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the menus
        loadMenu.add(openItem);
        saveMenu.add(saveTXTItem);
        saveMenu.add(savePNGItem);

        algorithmMenu.add(randomAlgItem);
        algorithmMenu.add(dfsAlgItem);
        algorithmMenu.add(bfsAlgItem);

        helpMenu.add(aboutItem);
        helpMenu.addSeparator(); // Add a separator line
        helpMenu.add(exitItem);

        // Add menus to the menu bar
        menuBar.add(loadMenu);
        menuBar.add(saveMenu);
        menuBar.add(algorithmMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }
}
