# Projeto API - Alpha Motors
> Status do Projeto: Em desenvolvimento :warning:



## Descrição
<p align="justify"> 
Esse projeto foi desenvolvido para o plano de estágio da empresa GFT Brasil, ele é um sistema API com a implementação do DTO (Data Transfer Object), de uma indústria automobilística que visa o controle da produção dos veículos,  do estoque, do sistema de venda de veículos produzidos e peças/acessórios e da compra das peças requisidas. </p>


## Funcionalidades
:heavy_check_mark: `Funcionalidade 1:`Realizar CRUD (Create Read Update Delete) de clientes que compram as peças e os veículos.

:heavy_check_mark: `Funcionalidade 2:`Realizar o CRUD (Create Read Update Delete) dos Produtos(peças) que foram compradas e vendidas.

:heavy_check_mark: `Funcionalidade 3:`Realizar o CRUD (Create Read Update Delete) Fornecedores das peças.

:heavy_check_mark: `Funcionalidade 4:`Realizar o CRUD (Create Read Update Delete) dos funcionários da industria.

:heavy_check_mark: `Funcionalidade 5:`Realizar o CRUD (Create Read Update Delete) dos veículos produzidos.

:heavy_check_mark: `Funcionalidade 6:`Realizar compra e venda e gerenciamento de estoque dos produtos e veículos.

## Tecnologias Utilizadas
<a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="100" height="100"/> </a> 
<a href="https://swagger.io/" target="_blank"> <img src="https://seeklogo.com/images/S/swagger-logo-A49F73BAF4-seeklogo.com.png" alt="swagger" width="100" height="100"/> </a>
<a href="https://spring.io/projects/spring-boot" target="_blank"> <img src="https://th.bing.com/th/id/R.7ae3e0f6900bc1220b2863247ba56963?rik=MHOyq7pC6N8Z1Q&pid=ImgRaw&r=0" alt="spring boot" width="100" height="100"/> </a>
<a href="https://www.mysql.com/products/workbench/" target="_blank"> <img src="https://pngimg.com/uploads/mysql/mysql_PNG35.png" alt="My SQL" width="140" height="100"/> </a>
<a href="https://www.mysql.com/products/workbench/" target="_blank"> <img src="https://th.bing.com/th/id/OIP.vfM_5nuzjcO4fP6SCdJsAQHaG8?pid=ImgDet&rs=1" alt="Eclipse" width="100" height="100"/> </a>
<a href="https://www.jetbrains.com/idea/promo/" target="_blank"> <img src="https://th.bing.com/th/id/OIP.SCmAIC4U5W4V0P0PoMw2owHaHa?pid=ImgDet&rs=1" alt="IntelliJ" width="100" height="100"/> </a>
<a href="https://www.postman.com/" target="_blank"> <img src="https://yt3.ggpht.com/a/AGF-l791ySSDFwSHTYVjI0BMuuyqlFmiMutGcvcYcA=s900-c-k-c0xffffffff-no-rj-mo" alt="IntelliJ" width="100" height="100"/> </a>

## Abrir e rodar o projeto
<p align="justify"> 
Para rodar o projeto primeiro iniciamos ele em uma IDE(Integrated Development Environment) no nosso caso foi o Eclipse e o IntelliJ. E para a visualização do nossos métodos que fizemos para as funcionalidades descritas acima preferimos a utilização do Swagger em vez do Postman, pois no primeiro todos os métodos já vinham construídos automaticamente se colocassemos as notações de forma correta.
Link do projeto depois de inicializada a aplicação na IDE : </p>

_ http://localhost:8080/swagger-ui.html_


## Explicação do Projeto 
Explicação do projeto e das tasks que queriamos realizar e as que foram concluídas em cada entidade e métodos.

### Classe Endereço
A classe endereço colocamos uma notação _@Embeddable_, pois ela é usada nas entidades de cliente e fornecedor. Com os atributos de logradouro, cep, complemento e número. Posteriormente, cabe a implementação de um consumo de API, por exemplo,  _https://viacep.com.br/_


### Entidade Fornecedor
A entidade fornecedor tem como atributos id (identificação), Razão Social, CNPJ, telefone, email, e o endereço puxado pela notação _@Embedded_ da classe endereço.

### Entidade Cliente
A entidade cliente foi criada com os atributos id, nome, cpf, telefone, email, com endereço da classe endereço.


### Entidade Produto
A entidade produto tem como atributos id (identificação), nome e a ligação com a classe Caracteristicas com o   _@Embedded_ .Além do crud básico existe um método que retorna o estoque (nome do produto junto com sua quantidade), e outro que cálcula automáticamente o preço de venda a partir da inserção do preço de custo.


### Classe Características 
A classe características _@Embeddable_ , foi criada para ser uma classe auxiliar à entidade produtos, contendo o id do fornecedor que está relacionado a aquele produto, sua descrição, quantidade, preço de custo, e o preço de venda



### Entidade Veículo
<p align="justify"> 
A entidade veículo, tem como os atributos id que é a sua identificação, ano, cor, marca, modelo, descrição, quantidade, preço de custo, preço de venda e a lista de produtos que foram usadas para a sua fabricação.

O atributo marca foi deixado como fixo (Alpha Motors), os atributos modelo e cor preferimos deixar como uma classe enum com atributos pré-definidos, do que deixar a escolha do usuário.
</p>

- Modelo: **_GROWING_UP, SINGLE_LADY, DOING_RIGHT, MOMMY_**

- Cor: **_PRETO, BRANCO, PRATA, CINZA, AMARELO, AZUL, VERMELHO_**

<p align="justify"> 
Fizemos um calculo para o preço de venda a partir da introdução do preço de custo com um adicional fixo de 20%. 
Em determinação no planejmaneto inicial, foi decidido que os insumos seriam abordados como um valor fixo, portanto neste projeto não haverá variação nos mesmos.
A definição do preço de venda será feita à parte da API, ficando a cargo do responsável da empresa fazer essa decisão.

</p>


### Compra 
Gera pedidos de compra para um fornecedor dos produtos(peças/acessórios). Não será gerado um pedido de compra caso o item não seja do fornecedor escolhido. O preço total da compra é gerado automaticamente de acordo com o preço de custo e quantidade dos itens incluídos.
É possivel imprimir uma lista das compras geral, por fornecedor e por funcionário que gerou a compra.
É possível deletar uma compra gerada.
As ações como gerar e deletar compras atualizam automaticamente o estoque.


### Venda
Gera pedidos de venda para um cliente dos produtos(peças/acessórios) e veículos. Não será gerado um pedido de venda caso o item não esteja cadastrado. O preço total da venda é gerado automaticamente de acordo com o preço de custo e quantidade dos itens incluídos.
É possivel imprimir uma lista das vendas geral, por cliente e por funcionário que gerou a venda.
É possível deletar uma venda gerada.
As ações como gerar e deletar vendas atualizam automaticamente o estoque.


## Desenvolvedores

[<sub>DANIELLE RODRIGUES DA SILVA QUEIROZ</sub>](https://git.gft.com/deqz)

[<sub>GABRIELA VASCONCELOS BARSAGLINI</sub>](https://git.gft.com/gavi)

[<sub>LETICIA DA SILVA MORAES</sub>](https://git.gft.com/laos)

[<sub>LOUISE GOLDSTEIN COSTA SIQUEIRA</sub>](https://git.gft.com/lesi) 

