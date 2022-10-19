# Projeto 3: 1º semestre de 2022
 
 
 ## Parceiro Acadêmico
MidAll</br>

![image](https://static.wixstatic.com/media/456d95_d8bfdcb4942b46c69950e9616742df4e~mv2.png/v1/fill/w_312,h_248,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/Logo%20MidAll.png)
##### *Figura 01. Fonte(www.midall.com.br)*

A MidAll é uma empresa de serviços e consultoria em TI, com sede no Parque Tecnológico em São José dos Campos. Desenvolve soluções de data driven, transformação digital, agilidade e eficiência e governança e segurança.


### Visão do Projeto

Criação de um motor de promoções em um Ecommerce, onde a criação, edição e exclusão de promoções possam ser feitas de forma ágil e intuitiva. Com requisitos funcionais:
* Interface de cadastro de produtos e promoções;
* Edição de produtos;
* Carrinho de compras;
* Criação de promoções;
* Categoria de promoções;
* Listagem de produtos e promoções.


Dessa forma, foi desenvolvido o PromoAll

<img src ="https://github.com/Doc-Docker/APIMidAll/blob/main/Images/logo2promoall.png" width="300" height="300"/>

##### *Figura 02. Fonte(www.github.com/Doc-Docker/APIMidAll)*

### Tecnologias utilizadas:

<div style="display: inline_block"><br> 
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="100" height="100" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/microsoftsqlserver/microsoftsqlserver-plain-wordmark.svg"  width="100" height="100" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" width="100" height="100" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angularjs/angularjs-original-wordmark.svg" width="100" height="100"  />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original-wordmark.svg" width="100" height="100" />
 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original-wordmark.svg" width="100" height="100" />
</div>

</br>

Para o front-end foi utilizado o Angular que é uma plataforma baseada em Typescript, para criação das telas de interação com o cliente, e para realizar as requisições para a API que foi desenvolvida. O Java com o framework Spring foi utilizado para criação da API de backend, com a criação das rotas HTTP, conexão com o banco de dados, tratamento de erros e aplicação das regras de negócio. Como banco de dados, foi utilizado o H2 que é um sistema de gerenciamento de banco de dados relacional em memória
         
         
#### Contribuições pessoais:

Desenvolvimento no front-end, utilizando o Angular, dentro desse desenvolvimento tivemos vários desafios na criação de telas, como:
* Criação das telas de cadastro de produtos; 
* Tela de cadastro de promoções;
* Tela de cadastro de categorias;
* Tela para representar o carrinho de compras;
* Tela de listagem e edição de produtos.
Além disso, tivemos o desafio de criar as requisições http de acordo com que foi desenvolvido no back end, consiliando o objeto json que seria enviado atrvés das requisições POST e PUT, e adaptando no layout os objetos recebidos através da requisição GET, além disso, enviar as informações corretas para a requisição DELETE
