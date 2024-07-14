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
        JSplitPane splitPane = createSplitPane(frame);

        // Create a button to toggle the left panel visibility
        JButton toggleButton = new JButton("Toggle Left Panel");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleLeftPanel(splitPane);
            }
        });

        // Create a panel for the toggle button
        JPanel togglePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        togglePanel.add(toggleButton);

        // Create a panel to hold the split pane and the toggle button panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(togglePanel, BorderLayout.NORTH);

        // Add main panel to frame
        frame.getContentPane().add(mainPanel);

        frame.setVisible(true);
    }
    private static JSplitPane createSplitPane(JFrame frame) {
        // Create a panel for buttons on the left (initially visible)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with gaps

        // Create and add buttons to the button panel
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

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

        // Create a JSplitPane to split the window into left and right components
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, buttonPanel, mazePanel);
        splitPane.setDividerLocation(200);
        splitPane.setEnabled(false);

        return splitPane;
    }

    private static void toggleLeftPanel(JSplitPane splitPane) {
        int newLocation;
        if (splitPane.getLeftComponent() != null) {
            // Collapse the left panel
            splitPane.setLeftComponent(null);
            newLocation = 0; // Adjust divider location to hide left panel
        } else {
            // Expand the left panel
            JPanel buttonPanel = createButtonPanel(); // Recreate button panel (if needed)
            splitPane.setLeftComponent(buttonPanel);
            newLocation = 200; // Set divider location to initial width
        }
        splitPane.setDividerLocation(newLocation);
    }

    private static JPanel createButtonPanel() {
        // Create a panel for buttons on the left
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with gaps

        // Create and add buttons to the button panel
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        return buttonPanel;
    }

    private static JMenuBar createMenuBar() {
        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu
        JMenu loadMenu = new JMenu("Load File");
        JMenu saveMenu = new JMenu("Save File");
        JMenu algorithmMenu = new JMenu("Change Algorithm");
        JMenu helpMenu = new JMenu("Help");

        // Create menu items
        JMenuItem openItem = new JMenuItem("Open Maze");
        JMenuItem saveTXTItem = new JMenuItem("Save to TXT file");
        JMenuItem savePNGItem = new JMenuItem("Save to PNG file");

        JMenuItem RandomAlgItem = new JMenuItem("Random Algorithm");
        JMenuItem BFSAlgItem = new JMenuItem("BFS Algorithm");
        JMenuItem DFSAlgItem = new JMenuItem("DFS Algorithm");

        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the menus
        loadMenu.add(openItem);
        saveMenu.add(saveTXTItem);
        saveMenu.add(savePNGItem);

        algorithmMenu.add(RandomAlgItem);
        algorithmMenu.add(DFSAlgItem);
        algorithmMenu.add(BFSAlgItem);

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
