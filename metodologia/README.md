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

Desenvolvimento no front-end, utilizando o Angular, dentro desse desenvolvimento tive vários desafios na criação de telas, como:
* Criação da tela home; </br>
   Desenvolvi a tela inicial da aplicação, utilizando o bootstrap para estilização da página, criação do componente home em TypeScript 
* Criação da tela de listagem de produtos</br>
   Desenvolvimento da tela com uma tabela para exibição dos dados adquiridos do banco de dados, criação da classe de services para fazer a conexão com o banco de dados e executar a requisição de getAll de produtos, utilizando api httpClient do angular
  
   <details>
     <summary>Código lista de produtos html</summary>
     
        <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr *ngFor="let product of products">
                        <td>{{ product.id }}</td>
                        <td>{{ product.name }}</td>
                        <td>{{ product.price }}</td>
                        <td>{{ product.description }}</td>

                        <td>
                            <select class="form-control" type="number" [(ngModel)]="product.quantidade">
                                <option [value]="n" *ngFor="let n of lista" >
                                  <p>{{n}}</p>
                                </option>
                            </select>
                        </td>

                        <td>

                            <button class="btn btn-primary" routerLink="/products-form/{{ product.id }}">
                                <i class="fa fa-edit"></i>
                            </button>

                           

                        </td>

                        <td>
                            <button  class="btn btn-success" (click)="addProduct(product)" >
                                <i class="fa fa-plus"></i>
                            </button>
                        </td>

                        <td>
                            <button  class="btn btn-danger" (click)="preDelete(product)"
                                    data-toggle="modal" data-target="#deleteModal" >
                                <i class="fa fa-trash"></i>
                            </button>
                        </td>
                
                    </tr>
                </tbody>
            </table> 
    </details>
    <details >
     <summary>Código da função que faz a requisição na classe service</summary>
     
          ngOnInit(): void {
             this.service
               .getProducts()
               .subscribe( res => this.products = res )
           }
     
    
            
     </details>
   


* Criação das telas de cadastro de produtos; </br>
   Desenvolvimento do formulário de cadastro de produtos, criação da classe de services para envio da requisição POST com objeto do tipo produto.
   
   <details>
      <summary>Código da função na classe service para criação e atualização de produtos </summary>
      
          onSubmit(){

           if(this.id){
             this.service.update(this.id, this.product)
             .subscribe( res => {
               this.success = true;
               this.errors = null;
             }
             )
           }
           else{

             this.service
               .insert(this.product)
               .subscribe( res =>{
                 this.success = true;
                 this.errors = null;

               }, errorRes =>{
                 this.success = false;
                 this.errors = errorRes.error.errors

               }

               )
           }


         }
   </details>
   
* Criação da tela de carrinho de compras;</br>
   Desenvolvimento de uma tela para mostrar todos os produtos selecionados pelo usuário no sistema
   <details>
      <summary>Código html para exibição dos produtos </summary>
      
          <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Discount</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr *ngFor="let p of products">
                        <td>{{ p.name }}</td>
                        <td>{{ p.price }}</td>
                        <td>{{ p.quantidade}}</td>
                        <td>-{{ p.discount }}</td>

                        <td>
                            <button  class="btn btn-warning" (click)="deleteProduct(p)">
                                <i class="fa fa-trash"></i>
                                Delete
                            </button>
                        </td>


                    </tr>
                </tbody>
                
            </table>
   </details>
   
* Criação da função no carrinho de compras para aplicação das promoções</br>

  <details>
      <summary>Código html para exibição do valor do carrinho aplicado os descontos </summary>
                 <tfoot>
                     <tr>
                         <th>Total Price:</th>
                         <th>{{ finalPrice }}</th>
                         <th></th>
                         <th></th>
                     </tr>
                     <tr>
                         <th>Price Without Discount:</th>
                         <th>{{ noDiscount }}</th>
                         <th></th>
                         <th></th>
                     </tr>

                 </tfoot>
   </details>

</br>
Além disso, tive o desafio de criar as requisições http de acordo com que foi desenvolvido no back end, consiliando o objeto json que seria enviado através das requisições POST e PUT, e adaptando no layout os objetos recebidos através da requisição GET, além disso, enviar as informações corretas para a requisição DELETE.


