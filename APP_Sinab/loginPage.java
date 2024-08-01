
import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LoginApp {

    private static final String VALID_CPF = "38355383818";
    private static final String VALID_PASSWORD = "123456";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login - SINAB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        JLabel cpfLabel = new JLabel("Usuário (CPF):");
        JTextField cpfField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Entrar");
        JButton forgotPasswordButton = new JButton("Não sei minha senha");

        // Configuração do layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(cpfLabel, gbc);
        gbc.gridx = 1;
        frame.add(cpfField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        frame.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(loginButton, gbc);
        gbc.gridy = 3;
        frame.add(forgotPasswordButton, gbc);

        // Usando expressão lambda
        loginButton.addActionListener(e -> {
            String cpf = cpfField.getText().replace(".", "").replace("-", ""); // Remove . e -
            String password = new String(passwordField.getPassword());

            if (isValidCpf(cpf) && cpf.equals(VALID_CPF)) {
                if (password.equals(VALID_PASSWORD)) {
                    JOptionPane.showMessageDialog(frame, "Login sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Senha incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Usando expressão lambda para o botão de recuperação de senha
        forgotPasswordButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Recuperação de senha não implementada", "Informação", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }

    private static boolean isValidCpf(String cpf) {
        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }
}
