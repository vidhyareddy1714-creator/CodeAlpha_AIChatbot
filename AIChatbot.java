import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AIChatbot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public AIChatbot() {

        setTitle("AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 15));

        // Send button
        sendButton = new JButton("Send");

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("Chatbot: Hello! Welcome to AI Chatbot.\n");
        chatArea.append("Chatbot: Ask me anything about Java or programming.\n\n");

        // Send button action
        sendButton.addActionListener(e -> sendMessage());

        // Press Enter to send a message
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {

        String userMessage = inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        chatArea.append("You: " + userMessage + "\n");

        String response = getBotResponse(userMessage);

        chatArea.append("Chatbot: " + response + "\n\n");

        inputField.setText("");

        // Automatically scroll to the latest message
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    // Basic NLP preprocessing and rule-based response generation
    private String getBotResponse(String message) {

        String text = message.toLowerCase().trim();

        // Remove punctuation
        text = text.replaceAll("[^a-z0-9\\s]", " ");

        // Normalize extra spaces
        text = text.replaceAll("\\s+", " ").trim();

        // Greeting rules
        if (text.matches(".*\\b(hi|hello|hey)\\b.*")) {
            return "Hello! How can I help you today?";
        }

        // Name
        if (text.contains("your name")) {
            return "I am Java AI Chatbot, your virtual assistant.";
        }

        // About the chatbot
        if (text.contains("who are you")) {
            return "I am a Java-based chatbot that uses simple NLP and rules.";
        }

        // Java questions
        if (text.contains("what is java")) {
            return "Java is an object-oriented programming language used to build applications.";
        }

        if (text.contains("what is oops") ||
            text.contains("oops")) {
            return "OOP stands for Object-Oriented Programming. Its main concepts are encapsulation, inheritance, polymorphism, and abstraction.";
        }

        if (text.contains("what is inheritance") ||
            text.contains("inheritance")) {
            return "Inheritance allows one class to acquire properties and methods from another class.";
        }

        if (text.contains("what is polymorphism") ||
            text.contains("polymorphism")) {
            return "Polymorphism means one interface or method name can have different behaviors.";
        }

        if (text.contains("what is arraylist") ||
            text.contains("arraylist")) {
            return "ArrayList is a resizable collection in Java that stores elements dynamically.";
        }

        // General programming questions
        if (text.contains("what is programming")) {
            return "Programming is the process of writing instructions that a computer can execute.";
        }

        if (text.contains("what is ai") ||
            text.contains("artificial intelligence")) {
            return "Artificial Intelligence enables computers to perform tasks that normally require human intelligence.";
        }

        if (text.contains("what is nlp") ||
            text.contains("natural language processing")) {
            return "NLP helps computers process and understand human language.";
        }

        // Frequently asked questions
        if (text.contains("how are you")) {
            return "I am doing great! Thank you for asking.";
        }

        if (text.contains("help")) {
            return "You can ask me about Java, OOP, inheritance, ArrayList, AI, NLP, or programming.";
        }

        if (text.contains("thank")) {
            return "You're welcome! Happy to help.";
        }

        if (text.matches(".*\\b(bye|goodbye|exit)\\b.*")) {
            return "Goodbye! Have a wonderful day.";
        }

        // Default response
        return "Sorry, I don't understand that question yet. Try asking about Java, OOP, AI, or NLP.";
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new AIChatbot();
        });
    }
}