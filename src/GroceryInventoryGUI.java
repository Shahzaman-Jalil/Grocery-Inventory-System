import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

class GroceryItem {
    int id;
    String name;
    double price;
    int quantity;
    String category;

    GroceryItem(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

public class GroceryInventoryGUI extends JFrame {
    private Stack<GroceryItem> inventory = new Stack<>();
    private JTextField txtId, txtName, txtPrice, txtQuantity, txtCategory;
    private JTable table;
    private DefaultTableModel tableModel;
    private Image backgroundImage;

    public GroceryInventoryGUI() {
        setTitle("🛒 Grocery Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ✅ Load Background Image
       // ✅ Load Background Image
    ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Images/background.png"));
    backgroundImage = backgroundIcon.getImage();



        // ✅ Background Panel
        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null)
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

                // Overlay
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, 120));
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
        bgPanel.setLayout(null);
        add(bgPanel);

        // Title
        JLabel title = new JLabel("GROCERY INVENTORY MANAGEMENT");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setBounds(180, 20, 500, 40);
        bgPanel.add(title);

        // Labels
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Color labelColor = new Color(240, 240, 240);

        JLabel lblId = createLabel("Product ID:", 140, 90, labelFont, labelColor);
        JLabel lblName = createLabel("Name:", 140, 130, labelFont, labelColor);
        JLabel lblPrice = createLabel("Price:", 140, 170, labelFont, labelColor);
        JLabel lblQuantity = createLabel("Quantity:", 140, 210, labelFont, labelColor);
        JLabel lblCategory = createLabel("Category:", 140, 250, labelFont, labelColor);

        bgPanel.add(lblId);
        bgPanel.add(lblName);
        bgPanel.add(lblPrice);
        bgPanel.add(lblQuantity);
        bgPanel.add(lblCategory);

        // Text Fields
        txtId = createInputField(250, 90);
        txtName = createInputField(250, 130);
        txtPrice = createInputField(250, 170);
        txtQuantity = createInputField(250, 210);
        txtCategory = createInputField(250, 250);

        bgPanel.add(txtId);
        bgPanel.add(txtName);
        bgPanel.add(txtPrice);
        bgPanel.add(txtQuantity);
        bgPanel.add(txtCategory);

        // Buttons
        JButton btnAdd = createButton("Add Item", 80, 310, new Color(0, 180, 255));
        JButton btnDelete = createButton("Delete Item", 290, 310, new Color(255, 100, 100));
        JButton btnUpdate = createButton("Update Item", 500, 310, new Color(255, 165, 0));
        JButton btnShow = createButton("Show Inventory", 290, 360, new Color(0, 200, 150));

        bgPanel.add(btnAdd);
        bgPanel.add(btnDelete);
        bgPanel.add(btnUpdate);
        bgPanel.add(btnShow);

        // ✅ Table for Inventory Display
        String[] columns = {"ID", "Name", "Price", "Quantity", "Category"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false; // make cells non-editable
            }
        };
        table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        table.getTableHeader().setBackground(new Color(220, 235, 255));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(new Color(180, 210, 255));
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(100, 410, 600, 140);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 2));
        scroll.getViewport().setBackground(Color.WHITE);
        bgPanel.add(scroll);

        // Button Actions
        btnAdd.addActionListener(e -> addItem());
        btnDelete.addActionListener(e -> deleteItem());
        btnUpdate.addActionListener(e -> updateItem());
        btnShow.addActionListener(e -> showInventory());

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        label.setBounds(x, y, 100, 25);
        return label;
    }

    private JTextField createInputField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 250, 25);
        field.setBackground(new Color(40, 40, 60));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 1));
        return field;
    }

    private JButton createButton(String text, int x, int y, Color baseColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 180, 35);
        button.setBackground(baseColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(baseColor.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });
        return button;
    }

    private void addItem() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            double price = Double.parseDouble(txtPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            String category = txtCategory.getText();

            inventory.push(new GroceryItem(id, name, price, quantity, category));
            JOptionPane.showMessageDialog(this, "✅ Item Added Successfully!");
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠ Please enter valid data!");
        }
    }

    private void deleteItem() {
        if (!inventory.isEmpty()) {
            inventory.pop();
            JOptionPane.showMessageDialog(this, "🗑 Last Item Deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "⚠ Inventory is Empty!");
        }
    }

    private void updateItem() {
        if (inventory.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠ Inventory is Empty!");
            return;
        }

        try {
            int idToUpdate = Integer.parseInt(txtId.getText());
            boolean found = false;
            Stack<GroceryItem> tempStack = new Stack<>();

            while (!inventory.isEmpty()) {
                GroceryItem item = inventory.pop();
                if (item.id == idToUpdate) {
                    item.name = txtName.getText();
                    item.price = Double.parseDouble(txtPrice.getText());
                    item.quantity = Integer.parseInt(txtQuantity.getText());
                    item.category = txtCategory.getText();
                    found = true;
                    JOptionPane.showMessageDialog(this, "🔄 Item Updated Successfully!");
                }
                tempStack.push(item);
            }

            while (!tempStack.isEmpty()) {
                inventory.push(tempStack.pop());
            }

            if (!found)
                JOptionPane.showMessageDialog(this, "❌ Item ID not found!");

            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "⚠ Please enter valid data!");
        }
    }

    private void showInventory() {
        tableModel.setRowCount(0); // clear previous data
        if (inventory.isEmpty()) {
            JOptionPane.showMessageDialog(this, "📦 No items in inventory.");
        } else {
            for (GroceryItem item : inventory) {
                tableModel.addRow(new Object[]{
                    item.id, item.name, item.price, item.quantity, item.category
                });
            }
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtCategory.setText("");
    }

    public static void main(String[] args) {
        new GroceryInventoryGUI();
    }
}
