# <p align="center"> BazarNovaVida ![image](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)


</p>

## <p align="center">Projeto Spring MVC - Bazar Igreja Batista Nova Vida</p>
<br>Tecnologias, Ferramentas e Técnicas utilizadas: 

 <br>![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
 <br>![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
 <br>![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
 <br>![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
 <br>![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
 <br>![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
 <br>![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
 <br>![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
 <br>	![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
 <br>
 <ul>
 <li>Padrão Arquitetural MVC</li>
 <li>Orientação a Objetos</li>
 <li>Padrões de projeto Command e Chain of Responsibility</li>
 <li>SOLID (Tentei pelo menos xD)</li>
</ul>
<br>Projeto em produção: https://bazarnovavida-production.up.railway.app (Projeto rodando no Railway em plano gratuito, fica ativo apenas 500h por mês)<br>
<br> Esse projeto MVC funciona como um comércio eletrônico de roupas usadas, tornando digital o bazar da minha igreja. O programa utiliza o padrão de aplicação em camadas, sendo os modelos e controladores em Java e a interface em HTML/CSS com Thymeleaf.

### <p align="center">Página inicial</p>
<br>Os itens são exibidos após uma requisição que recupera do banco de dados apenas os itens com o status de DISPONÍVEL.<br>

<br>![image](https://github.com/moriartynho/BazarNovaVida/assets/67657259/d624325a-25e4-45ba-8456-28d61049b6f4)

<br>Clicando no item, abre-se uma outra visualização que possibilita ao usuário que ele adicione ao seu carrinho, caso esteja logado - caso contrário, o usuário é redirecionado para a página de login para iniciar uma sessão. Quando um item é adicionado ao carrinho, seu estado é alterado para INDISPONIVEL, evitando que ele seja exibido na tela inicial.<br>

![image](https://github.com/moriartynho/BazarNovaVida/assets/67657259/8ec22eef-851e-43e5-9355-c0821b1499d7)

<br>O carrinho é um atributo da classe usuário que não é persistido, sendo uma lista de itens que quando confirmada pelo usuário em "Finalizar pedido" transforma-se em um pedido.<br>

![image](https://github.com/moriartynho/BazarNovaVida/assets/67657259/2a9a7294-53f4-433f-a481-e5f64eac98a9)

<br>O pedido de cada usuário é listado com base no ID registrado no banco de dados. Para evitar que um usuário tenha acesso a dados do pedido de outro usuário, existe uma condição na requisição que faz com que o id de usuário do pedido deva ser igual ao id do usuário logado - isso quer dizer que é necessário estar logado para ter acesso a essa página.<br>

<p align="center">
<img  src="https://github.com/moriartynho/BazarNovaVida/assets/67657259/f77cb0a3-a99a-4c73-8a18-baf8d04fef01">
 </p>
 
 <br>Visualização do pedido. O pedido possui 3 estado (EM ANDAMENTO, CANCELADO e CONCLUIDO). Quando um pedido é cancelado, os itens contidos dele voltam ao estado DISPONIVEL.<br>
 
 <p align="center">
<img  src="https://github.com/moriartynho/BazarNovaVida/assets/67657259/336fc72f-1663-4393-994d-edde6c0065b5">
 </p>
 
 <br>Essa página permite adicionar as peças no banco de dados para serem exibidas. Essa tela só pode ser acessada por usuários do tipo ADMINISTRADOR<br>
 
 ![image](https://github.com/moriartynho/BazarNovaVida/assets/67657259/fdf9767e-4c14-4d52-98ab-a598530f62f8)

<br><small>Ideias a serem implementadas: 
 <ul>
 <li>Página para listar todos os pedidos do banco de dados (recurso para usuários administradores)</li> 
 <li>implementação de formas de pagamento</li>
</ul>
  </small>
