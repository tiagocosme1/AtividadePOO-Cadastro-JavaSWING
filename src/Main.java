import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JTextField campoNomeCompleto;
    private JTextField campoEndereco;
    private JTextField campoCidade;
    private JComboBox<String> listaEstado;
    private JTextField campoTelefone;
    private JRadioButton opcaoAtivo;
    private JRadioButton opcaoInativo;

    private JButton botaoGravarDados;
    private JButton botaoCancelarDados;
    private JButton botaoVoltar;

    private ButtonGroup grupoStatus;

    public Main() {
        super("Cadastrar Clientes");

        setSize(550, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        configurarInterface();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void configurarInterface() {
        setLayout(new BorderLayout());

        JPanel painelTopo = new JPanel(new BorderLayout(0, 10));
        painelTopo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelInstrucao = new JLabel("Preencha os dados corretamente e clique em Gravar Dados", SwingConstants.CENTER);
        labelInstrucao.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel painelBotoesTopo = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));

        botaoGravarDados = new JButton("Gravar Dados");
        botaoGravarDados.addActionListener(this);

        botaoCancelarDados = new JButton("Cancelar Cadastro");
        botaoCancelarDados.addActionListener(this);

        painelBotoesTopo.add(botaoGravarDados);
        painelBotoesTopo.add(botaoCancelarDados);

        painelTopo.add(labelInstrucao, BorderLayout.NORTH);
        painelTopo.add(painelBotoesTopo, BorderLayout.CENTER);

        JPanel painelCampos = new JPanel(new GridLayout(6, 2, 10, 10));
        painelCampos.setBorder(BorderFactory.createEmptyBorder(0, 50, 20, 50));

        campoNomeCompleto = new JTextField();
        painelCampos.add(new JLabel("Nome Completo:"));
        painelCampos.add(campoNomeCompleto);

        campoEndereco = new JTextField();
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(campoEndereco);

        campoCidade = new JTextField();
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(campoCidade);

        String[] estados = {"Selecione", "SP", "RJ", "MG", "ES", "Outro"};
        listaEstado = new JComboBox<>(estados);
        painelCampos.add(new JLabel("Estado:"));
        painelCampos.add(listaEstado);

        campoTelefone = new JTextField();
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(campoTelefone);

        opcaoAtivo = new JRadioButton("Ativo", true);
        opcaoInativo = new JRadioButton("Inativo");

        grupoStatus = new ButtonGroup();
        grupoStatus.add(opcaoAtivo);
        grupoStatus.add(opcaoInativo);

        JPanel painelStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelStatus.add(opcaoAtivo);
        painelStatus.add(opcaoInativo);

        painelCampos.add(new JLabel("Status:"));
        painelCampos.add(painelStatus);

        JPanel painelVoltar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(this);

        painelVoltar.add(botaoVoltar);

        add(painelTopo, BorderLayout.NORTH);
        add(painelCampos, BorderLayout.CENTER);
        add(painelVoltar, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == botaoGravarDados) {
            executarValidacaoEGravacao();
        }
        else if (evento.getSource() == botaoVoltar) {
            dispose();
        }
        else if (evento.getSource() == botaoCancelarDados) {
            limparCampos();
        }
    }

    private void executarValidacaoEGravacao() {

        if (campoNomeCompleto.getText().trim().isEmpty()) {
            mostrarErro("O campo NOME deve ser preenchido.", campoNomeCompleto);
            return;
        }

        if (campoEndereco.getText().trim().isEmpty()) {
            mostrarErro("O campo ENDEREÇO deve ser preenchido.", campoEndereco);
            return;
        }

        if (campoCidade.getText().trim().isEmpty()) {
            mostrarErro("O campo CIDADE deve ser preenchido.", campoCidade);
            return;
        }

        if (listaEstado.getSelectedItem().equals("Selecione")) {
            mostrarErro("O campo ESTADO deve ser selecionado.", listaEstado);
            return;
        }

        if (campoTelefone.getText().trim().isEmpty()) {
            mostrarErro("O campo TELEFONE deve ser preenchido.", campoTelefone);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Dados do cliente gravados com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void limparCampos() {
        campoNomeCompleto.setText("");
        campoEndereco.setText("");
        campoCidade.setText("");
        campoTelefone.setText("");
        listaEstado.setSelectedItem("Selecione");

        opcaoAtivo.setSelected(true);

        campoNomeCompleto.requestFocus();
    }

    private void mostrarErro(String mensagem, JComponent componenteFoco) {
        JOptionPane.showMessageDialog(this,
                mensagem,
                "Erro de Preenchimento",
                JOptionPane.ERROR_MESSAGE);
        componenteFoco.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}