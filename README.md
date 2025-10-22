# 🧾 Sistema de Cadastro de Clientes (Java Swing)

Este projeto é uma aplicação Java desenvolvida com **Swing**, que
implementa uma interface gráfica simples para o **cadastro de
clientes**.

------------------------------------------------------------------------

## 📋 Descrição

O programa permite cadastrar clientes preenchendo informações básicas
como:

-   Nome completo\
-   Endereço\
-   Cidade\
-   Estado\
-   Telefone\
-   Status (Ativo / Inativo)

Também possui botões para **gravar dados**, **cancelar o cadastro**
(limpar campos) e **voltar** (fechar a janela).

------------------------------------------------------------------------

## 💻 Tecnologias Utilizadas

-   **Java 17+**\
-   **Swing (javax.swing)** para a interface gráfica\
-   **AWT (java.awt)** para layouts e componentes visuais\
-   **Event Handling** com `ActionListener`

------------------------------------------------------------------------

## ⚙️ Estrutura do Código

A classe principal é `Main`, que **estende `JFrame`** e **implementa
`ActionListener`**.

### Principais métodos:

-   `configurarInterface()` → Monta a interface gráfica e organiza os
    componentes.\
-   `executarValidacaoEGravacao()` → Valida os campos antes de gravar os
    dados.\
-   `limparCampos()` → Limpa todos os campos do formulário.\
-   `mostrarErro()` → Exibe mensagens de erro ao usuário.

------------------------------------------------------------------------

## 🧠 Lógica de Funcionamento

1.  O usuário preenche os campos do formulário.\
2.  Ao clicar em **"Gravar Dados"**, o sistema valida se todos os campos
    estão preenchidos.\
3.  Caso tudo esteja correto, é exibida uma mensagem de sucesso.\
4.  O botão **"Cancelar Cadastro"** limpa o formulário.\
5.  O botão **"Voltar"** fecha a janela atual.

------------------------------------------------------------------------

## ▶️ Como Executar

1.  Abra o projeto em uma IDE Java (como IntelliJ IDEA, Eclipse ou VS
    Code com extensão Java).\
2.  Compile e execute o arquivo **`Main.java`**.\
3.  A janela do cadastro será exibida automaticamente.

------------------------------------------------------------------------

## 📂 Estrutura de Arquivos

    📦 ProjetoCadastroClientes
     ┣ 📜 Main.java
     ┗ 📜 README.md

------------------------------------------------------------------------

## 🧑‍💻 Autor

Desenvolvido por **Tiago Cosme**
