# Projeto I - Assistente Ibet

## Parceiro Acadêmico

![image](https://sjc.fatec.sp.gov.br/static/media/logo.b8e0d5a7.png)
##### *Figura 01. Fonte(https://sjc.fatec.sp.gov.br/)*

### Visão do Projeto

A assistente virtual Ibet foi criada para oferecer aos usuários uma forma eficiente de acessar informações sobre esportes. Essa ferramenta conta com diversas funcionalidades que melhoram a experiência do usuário. Entre as principais características da Ibet, destacam-se:

<b> Configuração de Alarmes para Jogos: </b>  Os usuários podem programar alarmes para serem notificados sobre jogos específicos, garantindo que estejam sempre atualizados sobre as partidas que mais interessam.

<b> Placares em Tempo Real: </b> A Ibet fornece placares atualizados em tempo real para jogos em andamento, permitindo que os usuários acompanhem os resultados instantaneamente, sem atrasos.

<b> Acesso a Jogos Anteriores: </b> Além de informações sobre partidas atuais, a Ibet também oferece detalhes sobre jogos passados, permitindo que os usuários revivam momentos memoráveis do esporte.

<b> Vídeos e Conteúdo Relacionado: </b> A assistente disponibiliza acesso a vídeos e conteúdos esportivos, permitindo que os usuários assistam a momentos emocionantes, entrevistas e análises.

<b> Interação por Comando de Voz: </b> Um dos grandes diferenciais da Ibet é a possibilidade de interação por meio de comandos de voz. Assim, os usuários podem obter todas as informações necessárias sem precisar digitar ou clicar, tornando a experiência mais conveniente e intuitiva.

A Ibet foi projetada para fornecer informações de forma interativa, oferecendo aos usuários uma rica experiência no universo esportivo, sem os incômodos das interações tradicionais. Com sua funcionalidade de comando de voz, a assistente visa tornar a busca por informações esportivas mais prática e acessível.

### Tecnologias utilizadas:

<div style="display: inline_block"><br> 
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/python/python-original.svg" width="100" height="100"/>  
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sqlite/sqlite-original.svg" width="100" height="100"/>        
</div>

</br>

         
### Contribuições pessoais:

Desempenhei um papel crucial na implementação da tela para o usuário ,  
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
    
    * Tabela feita em html listando através de um ngFor do Angular os produtos que estão na lista de produtos que foram inseridas pela requisição get em produtos
     </br>
    <details >
     <summary>Código da função que faz a requisição na classe service</summary>
          
          
          
          ngOnInit(): void {
             this.service
               .getProducts()
               .subscribe( res => this.products = res )
           }
     
    
            
     </details>
     
     * Chamada do método de services para requisição get em produtos, retornando todos os produtos cadastrados no banco e inserindo em uma lista products


* Criação das telas de cadastro de produtos; </br>
   Desenvolvimento do formulário de cadastro de produtos, criação da classe de services para envio da requisição POST com objeto do tipo produto.
   
   <details>
      <summary>Código da função na classe service para criação e atualização de produtos </summary>
          
          * Método para envio de uma requisição POST para cadastrar produtos
          
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
   
   * Função que chama a requisição POST de produto, para inserção através do método na classe services
   
* Criação da tela de carrinho de compras;</br>
   Desenvolvimento de uma tela para mostrar todos os produtos selecionados pelo usuário no sistema
   
   <details>
      <summary>Código TS para exibição no carrinho de compras </summary>
          
          
          
          ngOnInit(): void {
            this.products = [];
            this.finalPrice = 0;
            this.product;
            this.discount;
            this.categoria=0;
            this.noDiscount = 0;
            this.lista = [];
            this.teste = [];
            Cart.products.forEach(element => {
              this.product = element;
              this.id  = element.id;
              this.quantidade = element.quantidade;
              this.categoria =  element.id;
              this.products.push(element);

                this.total = this.noDiscount += (element.price  * element.quantidade);

                this.service.getDiscount(this.id, this.quantidade, this.total, this.categoria).subscribe(
                    response =>
                    { const product : Product = new Product();
                      this.discount = response;
                      this.product.discount = this.discount
                      this.finalPrice = this.finalPrice += (element.price * element.quantidade)-(this.discount)
                      console.log("teste", this.categoria)
                    errorResponse => console.log(errorResponse)
                })
            });

          }

   </details>
   
    * Carrinho de compras em html para listagem dos produtos
   
   
* Criação da função no carrinho de compras para aplicação das promoções; </br>
    Desenvolvimento em TypeScript da função para aplicaçação dos descontos e desenvolvimento para visualização em html
    <details>
      <summary>Código html para exibição do valor do carrinho aplicado os descontos  </summary>
            
            
            
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
   </details>
   
   * Aplicando descontos no carrinho de compras e armazenando em uma variavel finalPrice 
   
* Criação do botão para adicionar produto no carrinho </br>
    Desenvolvimento do botão para adicionar o produto selecionado pelo cliente no carrinho de compras
    <details>
      <summary>Código html do botão  </summary>
           
           
           
           <button  class="btn btn-success" (click)="addProduct(product)" >
              <i class="fa fa-plus"></i>
           </button>
   </details>
   
   <details>
      <summary>Código TS para adição no carrinho  </summary>
      
           addProduct(product : Product){

             if(product.quantidade != null){ 
               Cart.products.push(product);
             }

             this.ngOnInit();
           }
   </details>
   
   * Adicionando produto na lista que representa o carrinho de compras
   


</br>
Além disso, tive o desafio de criar as requisições http de acordo com que foi desenvolvido no back end, consiliando o objeto json que seria enviado através das requisições POST e PUT, e adaptando no layout os objetos recebidos através da requisição GET, além disso, enviar as informações corretas para a requisição DELETE.

### Aprendizados efetivos HS:

  Dentro do desenvolvimento do sistema de E-commerce para a MidAll obtive diversos aprendizados novos, e aprofundei em outros, foram eles:
  
* Desenvolvimento de telas com Angular; </br>
   Para criação das telas foi utilizado o html e css, além do bootstrap como framework para o frontend. 
* Desenvolvimento com a linguagem TypeScript; </br>
   Foi necessário aprender sobre a linguagem TypeScript para criação dos arquivos service para efetivar as requisições HTTP
* Protocolo HTTP;
* Requisições GET, POST, PUT e DELETE; </br>
   Aprendi mais sobre essas requisições e como efetuar elas utilizando o Angular.
* Criação de um objeto JSON para envio nas requisições;
* Aprendi como fazer requisições no backend utilizando a api httpClient do Angular;
* Aprofundamento em aprendizados de banco de dados, DML, DQL, criação arquitetura de tabelas ;   
* Criação de um projeto em Vue; </br>
   Foi necessário aprender a estrutura de pastas de um projeto em Angular.</br>
   

  Os conhecimentos adquiridos em aula foram essencias para desenvolvimento desse projeto, aplicamos os conhecimentos aprendidos para seguir os padrões de arquitetura, torná-lo componentizável e seguindo modos de construção comuns aos utilizados no mercado e comunidade. Criação do banco de dados utilizado na aplicação, seguindo o padrão de chaves primaria e estrangeiras nas tabelas, criação do modelo e entidades do banco. Criação do padrão de pastas tanto no frontend como no backend. Aprendizados dos frameworks utilizados, vue e spring.
  
  
