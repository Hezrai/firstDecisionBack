<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
</head>
<body>
  <h1>Desafio Técnico: Cadastro de Usuários</h1>
 

Link para o video demonstrativo no youtube: https://www.youtube.com/watch?v=ZkuzS6wocg8
 

  
  <p>Este projeto é parte de um desafio técnico que visa implementar funcionalidades de cadastro de usuários em uma aplicação web desenvolvida utilizando Java (Spring) no back-end e Angular no front-end.</p>
  <h2>Funcionalidades Implementadas</h2>
  <ul>
    <li>Cadastro de Usuários: Desenvolvi uma página de registro de usuário no lado do Angular, permitindo que os usuários preencham campos como nome, e-mail, senha e confirmação de senha. Implementei validações para garantir que os dados inseridos atendam aos critérios especificados, como comprimento mínimo e máximo para o nome e a senha, e que o e-mail seja válido. Além disso, desabilitei o botão de envio enquanto houver erros de validação.</li>
    <li>API Java / Spring: Desenvolvi uma API RESTful no lado do Java / Spring para processar o registro de usuários. Esta API valida os dados recebidos da solicitação, incluindo a confirmação de senha, e armazena os usuários registrados em um banco de dados PostgreSQL. Implementei respostas apropriadas para o front-end, indicando sucesso ou erro no registro.</li>
    <li>Testes Unitários: Escrevi testes unitários tanto para a API Java quanto para a página Angular. Esses testes verificam se os dados são validados corretamente, se são armazenados no banco de dados e se as validações e o comportamento do botão de envio na página Angular estão funcionando conforme o esperado.</li>
    <li>Integração Angular / Java: Integrei a página de registro Angular com a API Java, permitindo que os dados do formulário sejam enviados para o back-end. Também implementei um tratamento de erro adequado na página Angular para lidar com falhas na comunicação com o back-end, garantindo uma experiência mais robusta para o usuário final.</li>
  </ul>
  <h2>Pré-requisitos</h2>
  <ul>
    <li>Node.js</li>
    <li>Angular CLI</li>
    <li>Java Development Kit (JDK)</li>
    <li>PostgreSQL</li>
  </ul>
  <h2>Como Executar o Projeto</h2>
  <ol>
    <li>Clone este repositório para sua máquina local.</li>
    <li>Instale as dependências do projeto Angular executando o comando npm install.</li>
    <li>Inicie o servidor Angular com o comando ng serve.</li>
    <li>Execute a API Java / Spring em seu ambiente de desenvolvimento.</li>
    <li>Certifique-se de configurar corretamente o banco de dados PostgreSQL.</li>
  </ol>
  <h2>Autor</h2>
  <p>Este projeto foi desenvolvido por Hezrai.</p>
  <h2>Imagens</h2>
<a href="https://ibb.co/5kMpH3R"><img src="https://i.ibb.co/C61CGyH/base.png" alt="base" border="0"></a>
<a href="https://ibb.co/0rbsW7r"><img src="https://i.ibb.co/PgHDbLg/base-Cadastrado-Sucesso.png" alt="base-Cadastrado-Sucesso" border="0"></a>
<a href="https://ibb.co/27JVNQW"><img src="https://i.ibb.co/GvmYTLn/base-Vazia.png" alt="base-Vazia" border="0"></a>
<a href="https://ibb.co/1Zt4FkN"><img src="https://i.ibb.co/y0cxHrC/boas-Vindas.png" alt="boas-Vindas" border="0"></a>
<a href="https://ibb.co/WH2tx55"><img src="https://i.ibb.co/4FVdmtt/botaaocadastro-Desabilitado.png" alt="botaaocadastro-Desabilitado" border="0"></a>
<a href="https://ibb.co/pXxQbvV"><img src="https://i.ibb.co/gg3dmMq/cadastrado-Com-Sucesso.png" alt="cadastrado-Com-Sucesso" border="0"></a>
<a href="https://ibb.co/M7DnVxV"><img src="https://i.ibb.co/tDMBsTs/Dados-Usuario.png" alt="Dados-Usuario" border="0"></a>
<a href="https://ibb.co/th2WH2D"><img src="https://i.ibb.co/VNCPLCT/Listausuarios.png" alt="Listausuarios" border="0"></a>
<a href="https://ibb.co/Z2YbRYw"><img src="https://i.ibb.co/xFfrKfc/Tela-Errosenha.png" alt="Tela-Errosenha" border="0"></a>
</body>
</html>
