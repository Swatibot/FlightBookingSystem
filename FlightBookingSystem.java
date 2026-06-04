import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlightBookingSystem extends JFrame implements ActionListener {

    JLabel title, nameLabel, flightLabel, seatLabel, paymentLabel, resultLabel;

    JTextField nameField, paymentField;

    JComboBox<String> flightBox, seatBox;

    JButton bookButton;

    public FlightBookingSystem() {

        setTitle("Flight Booking System");
        setSize(500, 400);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        title = new JLabel("FLIGHT BOOKING SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(100, 20, 300, 30);
        add(title);

        // Passenger Name
        nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(50, 80, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 80, 200, 25);
        add(nameField);

        // Flight Selection
        flightLabel = new JLabel("Select Flight:");
        flightLabel.setBounds(50, 130, 120, 25);
        add(flightLabel);

        String flights[] = {
                "AI101 - Bhubaneswar to Delhi",
                "AI202 - Delhi to Mumbai",
                "AI303 - Mumbai to Bangalore"
        };

        flightBox = new JComboBox<>(flights);
        flightBox.setBounds(180, 130, 220, 25);
        add(flightBox);

        // Seat Type
        seatLabel = new JLabel("Seat Type:");
        seatLabel.setBounds(50, 180, 120, 25);
        add(seatLabel);

        String seats[] = {
                "Window Seat",
                "Middle Seat",
                "Aisle Seat"
        };

        seatBox = new JComboBox<>(seats);
        seatBox.setBounds(180, 180, 150, 25);
        add(seatBox);

        // Payment
        paymentLabel = new JLabel("Payment Amount:");
        paymentLabel.setBounds(50, 230, 120, 25);
        add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setBounds(180, 230, 150, 25);
        add(paymentField);

        // Button
        bookButton = new JButton("Book Ticket");
        bookButton.setBounds(170, 280, 140, 35);
        bookButton.addActionListener(this);
        add(bookButton);

        // Result
        resultLabel = new JLabel("");
        resultLabel.setBounds(50, 330, 400, 25);
        add(resultLabel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String flight = (String) flightBox.getSelectedItem();
        String seat = (String) seatBox.getSelectedItem();

        double payment = Double.parseDouble(paymentField.getText());

        double fare = 5000;

        if (payment >= fare) {

            resultLabel.setText(
                    "Booking Confirmed | " + name +
                    " | " + seat +
                    " | Paid ₹" + payment
            );

            JOptionPane.showMessageDialog(this,
                    "Ticket Booked Successfully!\n\n" +
                    "Passenger: " + name +
                    "\nFlight: " + flight +
                    "\nSeat Type: " + seat +
                    "\nFare Paid: ₹" + payment);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Insufficient Payment!");
        }
    }

    public static void main(String[] args) {
        new FlightBookingSystem();
    }
}